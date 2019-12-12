package how2j.IO;

import java.util.Scanner;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 19:18
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(sort(s));
        Mains();
    }
    public static String sort(String string){
        char[] chars= string.toCharArray();
        for(int i=0;i<chars.length;i++){
            for(int j=i+1;j<chars.length;j++){
                if (((short)chars[i])>((short)chars[j])){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

    public static void Mains(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        while (true){
            int temp = getNum(s);
            System.out.println(temp);
            if(s==temp){
                break;
            }
            s /= temp;
        }
    }

    public static int getNum(int n){
        int i=2;
        while (n%(i)!=0){
            i++;
        }
        return i;
    }
}
