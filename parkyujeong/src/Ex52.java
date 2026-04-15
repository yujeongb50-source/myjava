public class Ex52 {public static void main(String[] args){

    Teat17 p1 = new Teat17("123456-1234567", "계백");

    System.out.println(p1.nation);
    System.out.println(p1.ssn);
    System.out.println(p1.name);

    //p1.nateion = "usa";
    //p1.ssn = "654321-7654321";
    p1.name = "을지문덕";               //final필드가 없는 name만 값 변경 가능
                                       //final필드 : 최종적인 값을 갖고 있는 필드 = 값을 변경할 수 없는 필드

    System.out.println(p1.name);
}
}
