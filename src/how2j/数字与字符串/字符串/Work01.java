package how2j.数字与字符串.字符串;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 12:49
 * 创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
 */
public class Work01 {
    public static void main(String []aug){
        Work01.randomCharToStringTwo();
        Work01.randomCharToString();
    }
    //方法1
    public static void randomCharToString(){
        char[] chars = new char[5];
        short start = '0';
        short end = 'z'+1;
        for (int i=0;i<chars.length;i++){
            while (true){
                char c = (char)((Math.random()*(end-start))+start);
                if(Character.isDigit(c)||Character.isLetter(c)){
                    chars[i] = c;
                    break;
                }
            }
        }
        String s = new String(chars);
        System.out.println(s);
    }

    public static String randomCharToStringTwo(){
        StringBuilder stringBuilder = new StringBuilder();
        for(short i='0';i<='9';i++){
            stringBuilder.append((char)i);
        }
        for (short i='A';i<='Z';i++){
            stringBuilder.append((char)i);
        }
        for (short i='a';i<='z';i++){
            stringBuilder.append((char)i);
        }
        char[] chars = new char[5];
        for (int i=0;i<chars.length;i++){
            int index = (int) (Math.random()*stringBuilder.length());
            chars[i] = stringBuilder.charAt(index);
        }
        String s = new String(chars);
        System.out.println(s);
        return s;
    }
}
