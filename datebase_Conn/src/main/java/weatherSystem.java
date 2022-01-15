import java.util.List;
import java.util.Scanner;
import Dao.weather_CRUD;
import pojo.weather;

public class weatherSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎来到天气系统");
        System.out.println("按键0,1,2 可查询北京天气;按键3,4,5 可查询上海天气; 按键6,7,8 可查询福州天气 ;按键9退出系统");
        boolean iscon=true;
        while (iscon){
            int input=sc.nextInt();
            if (input==9){
                System.out.println("正在退出系统，欢迎下次使用");
                iscon=false;
                break;
            }
            weather_CRUD weather_crud=new weather_CRUD();
            List<weather> weatherList=weather_crud.findById(input);
            System.out.println(weatherList.toString());
            System.out.println("可继续按键查找其他天气，或按9键退出");
        }
    }
}
