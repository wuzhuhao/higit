package how2j.IO.字符流;


import java.io.*;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 15:56
    准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
    设计一个方法

    public static void encodeFile(File encodingFile, File encodedFile);


    在这个方法中把encodingFile的行内容进加密，然后保存到encodedFile文件中。
    加密算法：
    数字：
    如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
    如果是9的数字，变成0
    字母字符：
    如果是非z字符，向右移动一个，比如d变成e, G变成H
    如果是z，z->a, Z-A。
    字符需要保留大小写
    非字母字符
    比如',&^ 保留不变，中文也保留不变
 */
public class TestStream {
    public static void main(String[] args) {
        String s = fileWriteFile();
        File encodingFile = new File(s);
        File encodFile = new File("D:\\xyz\\字符流练习\\encodFile.txt");
        try(FileWriter fw = new FileWriter(encodFile);
            FileReader fr = new FileReader(encodingFile)) {
            char[] all = new char[(int) encodingFile.length()];
            fr.read(all);
            System.out.format("加密前的内容是：%n%s%n",String.valueOf(all));
            for (int i=0;i<all.length;i++){
                if (isDigitOrLetter(all[i])){
                    if (Character.isDigit(all[i])){
                        int digit = ((int)all[i])+1;
                        if (digit==58){
                            digit = 48;
                        }
                        all[i] = (char) digit;
                    }else{
                        if (all[i]=='Z'){
                            all[i] = 'A';
                        }else if (all[i]=='z'){
                            all[i] = 'a';
                        }else
                            all[i] = (char) (((int)all[i])+1);
                    }
                }

            }
            fw.write(all);
            fw.flush();
            fw.flush();
            fr.read(all);
            System.out.format("加密后的内容是：%n%s%n",String.valueOf(all));
            fr.close();
        }catch (Exception e){

        }
    }

    public static String fileWriteFile() {
        // 准备文件test.txt
        File f = new File("D:\\xyz\\字符流练习\\test.txt");
        if (!f.exists()){
            f.getParentFile().mkdirs();
        }
        // 创建基于文件的Writer
        try (FileWriter fr = new FileWriter(f)) {
            // 以字符流的形式把数据写入到文件中
            String data="abcdef哈哈哈哈1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
            fr.flush();
            fr.close();
            System.out.println("写入文件成功");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return f.getAbsolutePath();
    }

    // 判断是否为字母或数字
    private static boolean isDigitOrLetter(char c) {
        String mark = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (mark.contains(String.valueOf(c))) {
            return true;
        }
        return false;
    }
}
