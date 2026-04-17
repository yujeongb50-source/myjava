package temp18;

public class Example {
    public static void main(String[] args){
        ImplementationC imp1 = new ImplementationC();

        InterfaceA ia = imp1;
        ia.methodA();
        System.out.println();

        InterfaceB id = imp1;
        id.methodB();
        System.out.println();

        InterfaceC ic = imp1;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
    
}
