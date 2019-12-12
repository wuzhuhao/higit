package how2j.数字与字符串.字符串;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 13:21
 * 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
 * 2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码
 * 要求： 分别使用多层for循环 和 递归解决上述问题
 */
public class Work03 {
    public static void main(String[] args) {
        String password = randomString(3);      //设置密码，调用方法得到长度为3的随机数
        System.out.println("密码是："+password);
        int num = 0;
        //1. 穷举法破解密码（多层for循环）
        char[] guessPassword = new char[3];     //先创建长度为3的猜测密码字符数组
        outloop:                                //打标点（用于跳出下面所有循环）
        for (int i = '0'; i <= 'z'; i++) {       //遍历第一个元素取值范围
            for (int j = '0'; j <= 'z'; j++) {       //遍历第二个元素取值范围
                for (int k = '0'; k <= 'z'; k++) {       //遍历第三个元素取值范围
                    num++;
                    if (!isLetterOrDigit(i,j,k)) {      //重写方法，只要不是字母或者数字就进入
                        continue;                       //排除字符，进入下次循环（不是跳出循环）
                    }
                    guessPassword[0] = (char)i;         //把剩下符合要求的字符赋值给数组元素
                    guessPassword[1] = (char)j;
                    guessPassword[2] = (char)k;
                    String guess = new String(guessPassword);//把猜测的字符数组转换成字符串
                    //System.out.println("穷举出的密码是："+guess);

                    if (guess.equals(password)) {               //猜测匹配密码
                        System.out.println("for循环法找到了，密码是："+guess); //得出结果
                        System.out.format("循环次数是%d",num);
                        break outloop;                  //返回标点，结束所有循环
                    }
                }
            }
        }
        //2. 穷举法破解密码（递归）
        char[] guessPassword2 = new char[3];    //先创建长度为3的猜测密码字符数组
        getPassword(guessPassword2,password);   //调用方法，传入猜测码，和密码
    }
    //递归需要调用的方法
    private static void getPassword(char[] guessPassword2, String password) {
        getPassword(guessPassword2, 0 , password);//方法调用方法，增加一个int类型，作为数组起始索引
    }
    //递归的方法调用的方法
    private static void getPassword(char[] guessPassword2, int i, String password) {
        for (int j = '0'; j <= 'z'; j++) {           //遍历数字的取值范围
            char c = (char) j;                      //转换成对应码表的字符
            if (!Character.isLetterOrDigit(c)) {    //调用方法，只要不是字母或者数字就进入
                continue;                           //排除字符，进入下次循环（不是跳出循环）
            }
            guessPassword2[i] = c;                  //把符合要求的字符赋值给数组元素
            if (i != guessPassword2.length-1) {     //如果起始索引不等于最后一位索引
                getPassword(guessPassword2, i+1, password);//调用这个方法，再次进入，索引增加1
            }else {                                         //如果超过了最后一位索引
                String guess2 = new String(guessPassword2); //把字符数组转换成字符串
                //System.out.println("穷举出的密码是：" + guess2);
                if (guess2.equals(password)) {              //猜测匹配密码
                    System.out.println("递归法找到了，密码是："+guess2);//输出结果
                }
            }
        }
    }

    //for循环需要调用的重写方法
    private static boolean isLetterOrDigit(int i, int j, int k) {
        //重写方法，判断三个数字对应的字符  都是字母或者数字 ，才返回true
        return Character.isLetterOrDigit(i)&&
                Character.isLetterOrDigit(j)&&
                Character.isLetterOrDigit(k);
    }

    //需要调用的随机数方法
    private static String randomString(int length) {
        //准备随机数的范围，用字符串接收
        String link = "";
        for (int j = '0'; j <= '9'; j++) {
            link += (char)j;
        }
        for (int j = 'a'; j <= 'z'; j++) {
            link += (char)j;
        }
        for (int j = 'A'; j <= 'Z'; j++) {
            link += (char)j;
        }
        System.out.println("随机范围是："+link);
        //从随机数范围里，随机指定的个数
        char[] cs = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random()*link.length());
            cs[i] = link.charAt(index);
        }
        link = String.valueOf(cs); //把字符数组转字符串
        return link;
    }
}

