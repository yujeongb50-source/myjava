public class Ex51 {public static void main(String[] args){

    Teat16 obj1 = Teat16.getInstance();
    Teat16 obj2 = Teat16.getInstance();

    if(obj1 == obj2) { 
        System.out.println("같은 Singleton 객체 입니다.");

    } else {
        System.out.println("다른 Singleton 객체 입니다.");
    }
    
}
}