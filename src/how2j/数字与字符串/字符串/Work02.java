package how2j.数字与字符串.字符串;

import java.util.Arrays;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 13:05
 * 创建一个长度是8的字符串数组
 * 使用8个长度是5的随机字符串初始化这个数组
 * 对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
 */
public class Work02 {
    public static void main(String arg[]){
        String[] strings = new String[8];
        for (int i=0;i<strings.length;i++){
            //调用随机函数获取随机String
            strings[i] = Work01.randomCharToStringTwo();
        }
        //输出排序前的字符串数组
        System.out.println(Arrays.toString(strings));
        //进行冒泡排序
        for (int i=0;i<strings.length;i++){
            for (int j=i;j<strings.length;j++){
                //获取字符数组i
                char[] ci = strings[i].toCharArray();
                //获取字符数组j
                char[] cj = strings[j].toCharArray();
                //进行第一个字符比较
                if (((short)Character.toLowerCase(ci[0]))>((short)Character.toLowerCase(cj[0]))){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        //输出排序后的字符串数组
        System.out.println(Arrays.toString(strings));
    }
}
