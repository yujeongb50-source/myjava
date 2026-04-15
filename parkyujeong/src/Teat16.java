public class Teat16 {

    private static Teat16 singleton = new Teat16();

    private Teat16() {}

    static Teat16 getInstance() {
        return singleton;
    }
    
}
