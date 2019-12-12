package bubbleSort;

import collection.Node;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: wuzhuhao
 * @Date: 2019/5/28 9:19
 */
public class BubbleSortTest {
    int data[];
    public BubbleSortTest(){
        initData();
    }

    public void initData(){
        Random random = new Random();
        data = new int[4*10000];
        for(int i=0;i<data.length;i++){
            data[i] = random.nextInt(2*4*10000);
        }
    }

    public void selectSort(){
        int data_temp[] = new int[data.length];
        System.arraycopy(data,0,data_temp,0,data.length);
        int start = getCurrentTime();
        for (int i=0;i<data_temp.length;i++){
            for (int j=i+1;j<data_temp.length;j++){
                if (data_temp[j]<data_temp[i]){
                    int temp;
                    temp = data_temp[j];
                    data_temp[j] = data_temp[i];
                    data_temp[i] = temp;
                }
            }
        }
        int end = getCurrentTime();
        System.out.println("选择法耗费的时间是："+(end-start));
        System.out.println(Arrays.toString(data_temp));
    }

    public void bubbleSort(){
        int data_temp[] = new int[data.length];
        System.arraycopy(data,0,data_temp,0,data.length);
        int start = getCurrentTime();
        for (int i = 0; i < data_temp.length ; i++) {
            for (int j = 0; j < data_temp.length-i-1 ; j++) {
                if (data_temp[j]>data_temp[j+1]){
                    int temp;
                    temp = data_temp[j];
                    data_temp[j] = data_temp[j+1];
                    data_temp[j+1] = temp;
                }
            }
        }
        int end = getCurrentTime();
        System.out.println("冒泡排序耗费的时间是："+(end-start));
        System.out.println(Arrays.toString(data_temp));
    }

    public void treeSort(){
        int start = getCurrentTime();
        Node node = new Node();
        for (int i:data) {
            node.add(i);
        }
        System.out.println(node.values());
        int end = getCurrentTime();
        System.out.println("二叉树排序耗费的时间是："+(end-start));
    }

    public int getCurrentTime(){
        return (int) System.currentTimeMillis();
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        BubbleSortTest bubbleSortTest = new BubbleSortTest();
        bubbleSortTest.selectSort();
        bubbleSortTest.bubbleSort();
        bubbleSortTest.treeSort();
    }
}
