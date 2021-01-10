package bean;

public class Car {

//  汽车品牌。benz、bmw
    public String band;
//    汽车颜色：白色、红色
    public String color;

    @Override
    public String toString() {
        return "Car{" +
                "band='" + band + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car() {
    }

    public Car(String band, String color) {
        this.band = band;
        this.color = color;
    }
}
