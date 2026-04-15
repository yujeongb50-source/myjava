public class Teat05 {

    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Teat05() {

    }

    Teat05(String model) { 
        this.model = model;
    }

    Teat05(String model, String color){
        this.model = model;
        this.color = color;
    }

    Teat05(String model, String color,  int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    

}
