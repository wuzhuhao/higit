package niuke.shixian;

import niuke.TestObstract;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/12 12:08
 */
public class hrio_Abstract extends TestObstract {

    public static void main(String[] args) {
        hrio_Abstract s = new hrio_Abstract();
        System.out.println(s.method());
        int i = 5;
        int num = (i++)+(++i)+(i--)+(--i);
        System.out.println("num是"+num+";i是"+i);
        System.out.println(gg(4));
        int[] num1={0};
        int BT[] = {0,1,2,3,4,5,0,0};
        a(BT,3,1,num1);
        System.out.println(num1[0]);
    }

    public static int gg(int n){
        if(n==1||n==2){
            return n;
        }
        return gg(n-1)+gg(n-2);
    }

    public static void a(int[] bt,int h,int node,int[] num){
        boolean a,b;
        if (a=(node*2<=Math.pow(2,h)-1&&bt[node*2]!=0)){
            a(bt,h,node*2,num);//存在即递归左子树
        }
        if (b=(node*2+1<=Math.pow(2,h)-1&&bt[node*2+1]!=0))
            a(bt,h,node*2+1,num);//存在即递归右子树
        if (!a&&!b){
            num[0]++;
        }
    }
}
