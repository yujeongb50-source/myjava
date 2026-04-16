package temp9;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();

        Parent1 parent = child;

        parent.method1();

        parent.method2();
    }
    
}
