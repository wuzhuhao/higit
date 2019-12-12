package how2j.characterTest;

import java.util.Scanner;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 12:30
 */
public class word01 {
    public static void main(String aug[]){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        char[] chars = str1.toCharArray();
        for (char cs:chars){
            if(Character.isUpperCase(cs)||Character.isDigit(cs)){
                System.out.print(cs);
            }
            else
                continue;
        }
    }
}
