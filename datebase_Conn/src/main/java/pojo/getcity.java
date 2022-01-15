package pojo;

import Dao.City_CRUD;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class getcity {
    public static void main(String[] args) throws IOException {
        URL url;//调用API的路径
        URLConnection conn;//建立url连接
        InputStream in;//url连接的字节流
        InputStreamReader isr;//url连接的字符流
        StringBuffer sb;//缓冲字符串提高效率
        JSONObject jsonObject,JO;//处理JSON字符串中的JSON对象
        JSONArray jsonArray;//处理json字符串中的json数组
        String path="https://geoapi.qweather.com/v2/city/lookup?key=9a2149cc12b14263866453409a1ca23a&location=fuzhou";
        url=new URL(path);
        //创建一个URLConnection连接对象
        conn=url.openConnection();
        //创建一个输入流来接收网页
        in=conn.getInputStream();
        //字节流——>字符流
        isr = new InputStreamReader(in,"UTF-8");
        //从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
        GZIPInputStream gzipInputStream =new GZIPInputStream(in);
        StringBuilder res=new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new
                InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
        while ((line = br.readLine()) != null) {
            res.append(line);
        }
        String str=res.toString();
        //System.out.println(res);
        jsonObject=JSONObject.fromObject(str);
        jsonArray = jsonObject.getJSONArray("location");

        JO = jsonArray.getJSONObject(0);
        String name=JO.getString("name");
        String id=JO.getString("id");
        String lat=JO.getString("lat");
        String lon=JO.getString("lon");
        System.out.println(name+" "+id+" "+lat+" "+lon);
        int id1=Integer.parseInt(id);
        City city=new City(id1,name,lon,lat);
        City_CRUD city_crud=new City_CRUD();
        city_crud.SaveCity(city);







    }

}
