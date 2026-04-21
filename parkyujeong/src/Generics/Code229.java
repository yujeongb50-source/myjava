package Generics;
class Data<T>{
    T obj;
    Data(T ob) {
        obj = ob;
    }
    T getObj() {
        return obj;
    }
    
    public void showType() {System.out.println("Type of T:" +obj.getClass().getName());
    }
}



public class Code229 {
    public static void main(String[] args) {
        Data<Integer> d1 = new Data<Integer>(100); //정수 100인수
        System.out.println(d1.getObj());
        d1.showType();

        Data<String> d2 = new Data<String>("JAVA"); //문자열 "JAVA" 인수
        System.out.println(d2.getObj());
        d2.showType();
    }
    
}
