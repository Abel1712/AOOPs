package prcatice;
import java.util.*;
public class genericWildcard {
    public static void main(String[] args) {
        ArrayList <Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        printList(a);
        List <String> s= new ArrayList<>();
        s.add("hi");
        s.add("bye");
        printList(s); 
       
 
    }
    public static void printList(List <?> ls){
     System.out.println(ls);
    }
}

