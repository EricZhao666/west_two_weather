package pojo;

public class weather {
    private String Data;
    private String tempMax;
    private String tempMin;
    private String textDay;
    private String cityname;
    private int id;

    public weather() {
    }

    public weather(int id, String cityname,String data, String tempMax, String tempMin, String textDay) {
        Data = data;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
        this.cityname = cityname;
        this.id=id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public String getName() {
        return cityname;
    }

    public void setName(String name) {
        this.cityname = name;
    }

    @Override
    public String toString() {
        return "weather{" +
                "Data='" + Data + '\'' +
                ", tempMax='" + tempMax + '\'' +
                ", tempMin='" + tempMin + '\'' +
                ", textDay='" + textDay + '\'' +
                ", cityname='" + cityname + '\'' +
                ", id=" + id +
                '}';
    }
}
