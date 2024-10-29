package prcatice;

public class lambda {
    public static void main(String[] args) {
        operation<Integer> add = (a,b) -> {
            System.out.println("Adding ");
            return a+b;
        };
        System.out.println(add.justdoit(2, 4));
        
        operation<Integer> sub = (a,b) -> a-b;
        System.out.println(sub.justdoit(4, 2));
    }
}
 

 interface  operation <T extends Number>{
     T justdoit(T a,T b);
    
}
