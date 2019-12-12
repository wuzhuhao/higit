package how2j.IO.字节流;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.lang.*;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 15:14
 *
    找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
    比如文件 eclipse.exe，大小是309k。
    拆分之后，成为
    eclipse.exe-0
    eclipse.exe-1
    eclipse.exe-2
    eclipse.exe-3
 */
public class SplitFile {
    public static void main(String []arg){
        System.out.println(Arrays.toString(splitFile()));
    }

    public static String[] splitFile() {
        InputStream is = null;
        OutputStream os = null;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            File f = new File("D:\\xyz\\split\\mmexport1477820740796.jpg");
            is = new FileInputStream(f);
            byte[] buffer = new byte[1024*100];
            int len = -1;
            int i = 0;
            while ((len=is.read(buffer))!=-1){
                System.out.format("分离第%d个文件%n",i+1);
                String s = "D:\\xyz\\split\\mmexport1477820740796.jpg-"+i;
                File temp = new File(s);
                os = new FileOutputStream(temp);
                os.write(buffer);
                os.flush();
                os.close();
                linkedList.add(s);
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (is!=null){
                    is.close();
                }
                if(os!=null){
                    os.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String[] re = new String[linkedList.size()];
        linkedList.toArray(re);
        return re;
    }
}
