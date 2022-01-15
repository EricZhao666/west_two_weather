package pojo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Dao.weather_CRUD;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPInputStream;
public class getWeather {
    static int id=0;
    public static void main(String[] args) throws IOException {
        JSONObject jsonObject1,jsonObject2,jsonObject3;//处理JSON字符串中的JSON对象
        JSONArray jsonArray1;//处理json字符串中的json数组
        JSONArray jsonArray2;
        JSONArray jsonArray3;
        String str1=getWeather("https://devapi.qweather.com/v7/weather/3d?key=9a2149cc12b14263866453409a1ca23a&location=101010100");
        String str2=getWeather("https://devapi.qweather.com/v7/weather/3d?key=9a2149cc12b14263866453409a1ca23a&location=101020100");
        String str3=getWeather("https://devapi.qweather.com/v7/weather/3d?key=9a2149cc12b14263866453409a1ca23a&location=101230101");
        // beijing 101010100 shanghai 101020100 fuzhou 101230101
        jsonObject1=JSONObject.fromObject(str1);
        jsonObject2=JSONObject.fromObject(str2);
        jsonObject3=JSONObject.fromObject(str3);
        jsonArray1 = jsonObject1.getJSONArray("daily");
        jsonArray2 = jsonObject2.getJSONArray("daily");
        jsonArray3 = jsonObject3.getJSONArray("daily");
        for (int i = 0; i < 3; i++) {
            weather weather=getCityWeather(jsonArray1,"beijing",id,i);
            weather_CRUD weather_crud=new weather_CRUD();
            List<weather> weatherList=weather_crud.findById(id);
            if (weatherList.isEmpty()!=false){
                weather_crud.updateWeather(weather);
            }else {
                weather_crud.saveWeather(weather);
            }
            id++;
        }
        for (int i = 0; i < 3; i++) {
            weather weather=getCityWeather(jsonArray2,"shanghai",id,i);
            weather_CRUD weather_crud=new weather_CRUD();
            List<weather> weatherList=weather_crud.findById(id);
            if (weatherList.isEmpty()!=false){
                weather_crud.updateWeather(weather);
            }else {
                weather_crud.saveWeather(weather);
            }
            id++;
        }
        for (int i = 0; i < 3; i++) {
            weather weather=getCityWeather(jsonArray3,"fuzhou",id,i);
            weather_CRUD weather_crud=new weather_CRUD();
            List<weather> weatherList=weather_crud.findById(id);
            if (weatherList.isEmpty()!=false){
                weather_crud.updateWeather(weather);
            }else {
                weather_crud.saveWeather(weather);
            }
            id++;
        }


    }
    public static String getWeather(String path) throws IOException{
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
    public static weather getCityWeather(JSONArray jsonArray, String cityname, int id,int i){
        JSONObject JO;
        JO = jsonArray.getJSONObject(i);
        String Data=JO.getString("fxDate");
        String tempMax=JO.getString("tempMax");
        String tempMin=JO.getString("tempMin");
        String textDay=JO.getString("textDay");
        weather weather=new weather(id,cityname,Data,tempMax,tempMin,textDay);
        return weather;
    }

}
