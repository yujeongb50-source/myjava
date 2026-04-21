package Generics;
import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>{
    private int id;
    private int score;
    Person(){}
    Person(int id, int score) { this.id = id; this.score = score;}
    public String toString() { return "[id=" + id +", score=" + score +"}";}
    public int compareTo(Person p){
        return this.id - p.id;
    }
}

public class Code244 {
    public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person(3, 83));
        ts.add(new Person(5,90));
        ts.add(new Person(1,93));
        ts.add(new Person(2,88));
        ts.add(new Person(4,70));

        Iterator<Person> itr = ts.iterator();
        while(itr.hasNext())
        System.out.println(itr.next());
    }
    
}
