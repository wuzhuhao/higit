package how2j.IO.字节流;

import java.io.*;
/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 15:00
 *
 *
    以字节流的形式向文件写入数据 中的例子，当lol2.txt不存在的时候，是会自动创建lol2.txt文件的。
    但是，如果是写入数据到d:/xyz/lol2.txt，而目录xyz又不存在的话，就会抛出异常。
    那么怎么自动创建xyz目录？
    如果是多层目录 d:/xyz/abc/def/lol2.txt 呢？
 */
public class WriteTxt {
    public static void main(String []arg){
        FileOutputStream fos=null;
        try {
            File f = new File("d:/xyz/lol2.txt");
            if(!f.exists()){
                f.getParentFile().mkdirs();
            }
            byte data[] = {88,89};
            fos = new FileOutputStream(f);
            fos.write(data);
            // 关闭输出流
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(fos!=null){
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
