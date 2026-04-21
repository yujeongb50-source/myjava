package Generics;

class Data1<T extends Number>{
T obj;
Data1(T ob){
    obj=ob;
}
int calcMultiple(int n) {
    return obj.intValue()*n;
}
}
public class Code231 {
    public static void main(String[]args) {
        Data1<Integer> d = new Data1<Integer>(100);
        int result = d.calcMultiple(5);
        System.out.println(result);

        Data1<Double> e=new Data1<Double>(17.5);
        int result2 = e.calcMultiple(5);
        System.out.println(result2);
    }
    
}
