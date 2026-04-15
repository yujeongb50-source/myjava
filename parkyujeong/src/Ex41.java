public class Ex41 {public static void main(String[] args){

    Teat06 car1 = new Teat06();
    System.out.println("car1.company:" + car1.company);
    System.out.println();

    Teat06 car2 = new Teat06("자가용");
    System.out.println("car2.company:" + car2.company);
    System.out.println("car2.model:" + car2.company);
    System.out.println();

    Teat06 car3 = new Teat06("자가용","빨강");
    System.out.println("car3.company:" + car3.company);
    System.out.println("car3.model:" + car3.company);
    System.out.println("car3.color:" + car3.color);
    System.out.println();

    Teat06 car4 = new Teat06("자가용","빨강",200);
    System.out.println("car4.company:" + car4.company);
    System.out.println("car4.model:" + car4.company);
    System.out.println("car4.color:" + car4.color);
    System.out.println("car4.maxSpeed:" + car4.maxSpeed);
}
}
