

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

/*        try {
            Class clazz = Class.forName("com.weaver.agent.asm.AgentClient");
            Method method = clazz.getMethod("addEntity");
            method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        String ip = "57b6884649fc42ecb56a137ceb49dbb8";
        String param = "{\"sfStack\":\""+ Arrays.toString(Thread.currentThread().getStackTrace()) +"\",\"ip\":\""+ip+"\"}";
        try {
            URL url = new URL("http://127.0.0.1:9001/agent/setFileDel");
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);
            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }



        /*HttpURLConnection conn = null;
        BufferedReader br = null;
        StringBuffer resultBuffer = new StringBuffer();
        try {
            URL http = new URL("http://127.0.0.1:9001/agent/getValue/dacc96dc9ddc48468deb2077d34ad568");
            conn = (HttpURLConnection) http.openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
            System.out.println(resultBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*



        System.out.println("6666666666666666666666");*/

        File f = new File("D:\\Work\\1.log");
        f.delete();
    }
}
