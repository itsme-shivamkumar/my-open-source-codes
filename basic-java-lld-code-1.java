import java.util.*;
public class Main{
    public static void main(String[] args){
        Main obj = new Main();
        obj.sout("hello"); // Output: hello
        obj.sout(2); // Output: 2
        Collection<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(20);
        list.sort();
        obj.sout(list);
    }
    <T> void sout(T s){
        System.out.println(s);
    }
}