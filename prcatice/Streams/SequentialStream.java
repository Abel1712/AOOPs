package prcatice.Streams;
import java.util.*;
public class SequentialStream {
    public static void main(String [] args){
     ArrayList <String> ls = new ArrayList<>();
     String str = " Nothing ";
     String str2 = " Makes ";
     String str3 = " Sense";
     ls.add(str);
     ls.add(str2);
     ls.add(str3);

     ls.stream().forEach(System.out::print);
     System.out.println();
     System.out.println("parallel stream ");
     ls.parallelStream().forEach(System.out::print);
     System.out.println();
     System.out.println("parallel stream ");
     ls.parallelStream().forEachOrdered(System.out::print);

    }
}
