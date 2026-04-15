public class Teat06 {
    

    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Teat06() {

    }

    Teat06(String model) { 
        this(model, null,0);
    }

    Teat06(String model, String color) {
        this(model, color, 0);
    }

    Teat06(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
