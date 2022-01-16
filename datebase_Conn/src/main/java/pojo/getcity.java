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

        JSONObject jsonObject1,jsonObject2,jsonObject3;//处理JSON字符串中的JSON对象
        JSONArray jsonArray1,jsonArray2,jsonArray3;
        String str1=getCity("https://geoapi.qweather.com/v2/city/lookup?key=9a2149cc12b14263866453409a1ca23a&location=beijing");
        String str2=getCity("https://geoapi.qweather.com/v2/city/lookup?key=9a2149cc12b14263866453409a1ca23a&location=shanghai");
        String str3=getCity("https://geoapi.qweather.com/v2/city/lookup?key=9a2149cc12b14263866453409a1ca23a&location=fuzhou");
        jsonObject1=JSONObject.fromObject(str1);
        jsonObject2=JSONObject.fromObject(str2);
        jsonObject3=JSONObject.fromObject(str3);
        jsonArray1 = jsonObject1.getJSONArray("location");
        jsonArray2 = jsonObject2.getJSONArray("location");
        jsonArray3 = jsonObject3.getJSONArray("location");
        City city1=getCityLocation(jsonArray1,0);
        City city2=getCityLocation(jsonArray2,0);
        City city3=getCityLocation(jsonArray3,0);
        getInto(city1);
        getInto(city2);
        getInto(city3);

    }
    public static String getCity(String path) throws IOException{
        URL url;//调用API的路径
        URLConnection conn;//建立url连接
        InputStream in;//url连接的字节流
        InputStreamReader isr;//url连接的字符流
        StringBuffer sb;//缓冲字符串提高效率


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
        return str;
    }
    public static City getCityLocation(JSONArray jsonArray,int i){
        JSONObject JO;
        JO = jsonArray.getJSONObject(i);
        JO = jsonArray.getJSONObject(0);
        String name=JO.getString("name");
        String id=JO.getString("id");
        String lat=JO.getString("lat");
        String lon=JO.getString("lon");
        int id1=Integer.parseInt(id);
        City city=new City(id1,name,lon,lat);
        return city;
    }
    public static void getInto(City city){
        City_CRUD city_crud=new City_CRUD();
        city_crud.SaveCity(city);
        System.out.println("save success");
    }

}
