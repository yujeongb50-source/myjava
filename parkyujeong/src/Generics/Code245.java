package Generics;
import java.util.Comparator;
import java.util.TreeSet;
class Person{
    private int id;
    private int score;
    Person() {}
    Person (int id, int score) { this.id = id; this.score = score;}
    int getld() { return id;}
    public String toString() { return "[id=" + id + ", score=" + score + "]";}
}

class PersonComparator implements Comparator<Person> {
    public int compare (Person o1, Person o2){
        return o1.getld() - o2.getld();
    }
}


public class Code245 {
    public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<>(new PersonComparator());
        ts.add(new Person(4,83));
        ts.add(new Person(5,90));
        ts.add(new Person(2,93));
        ts.add(new Person(1,88));
        ts.add(new Person(3,70));
        for(Person p:ts)
        System.out.println(p);
    }
    
}
