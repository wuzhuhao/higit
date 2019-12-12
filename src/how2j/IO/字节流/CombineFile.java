package how2j.IO.字节流;

import java.io.*;

/**
 * @Author: wuzhuhao
 * @Date: 2019/10/18 15:27
    把上述拆分出来的文件，合并成一个原文件。
    以是否能正常运行，验证合并是否正确
 */
public class CombineFile {
    public static void main(String[] arg){
        String[] strings = SplitFile.splitFile();
        InputStream is = null;
        OutputStream os = null;
        if (strings.length<=0){
            System.out.println("无文件可合并！");
            return;
        }
        try {
            File f = new File(new File(strings[0]).getParentFile().getAbsoluteFile()+"\\newFile.jpg");
            os = new FileOutputStream(f);
            for (int i=0;i<strings.length;i++){
                File temp = new File(strings[i]);
                is = new FileInputStream(temp);
                byte[] buffer = new byte[1024*100];
                int len = -1;
                while ((len=is.read(buffer))!=-1){
                    os.write(buffer);
                    os.flush();
                }
                is.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (is!=null){
                    is.close();
                }
                if (os!=null){
                    os.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
