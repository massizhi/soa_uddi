package com.mkx.soa.config.remoteProcedureCall;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUrlConnection2 {
    public static void main(String[] args) throws IOException {
        //第一步：创建服务地址
        URL url = new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName=福州");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        connection.setRequestMethod("GET");
        connection.setReadTimeout(5000);

        //第四步：接收服务端响应，打印
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){//表示服务端响应成功
            //获取当前连接请求返回的数据流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }
            //打印结果
            System.out.println(sb.toString());

            is.close();
            isr.close();
            br.close();
        }
        connection.disconnect();
    }
}
