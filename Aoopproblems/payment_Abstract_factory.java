import java.util.*;
public class payment_Abstract_factory {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            A authenciate = A.getInstance();
            sc.nextLine();
      if(authenciate.code == n){
    
    String str = sc.nextLine();
    factory_pay f ;
    if(str.equalsIgnoreCase("online")){
        f = new onlinefactory();
    }
    else {
        f = new cashFactory();
    }
    PaymentMode p = f.getInstance(str);
    p.print();
    sc.close();
            }
            else{
                System.out.println("entre correct code");
            }
            
        }
    }
    // Authentication
    
     class A {
        static A a ;
        int code = 256;
        private A(){
             
        }
         public static A getInstance(){
            if(a == null){
                return new A();
            }
            return a;
         }

        
    }


interface PaymentMode {
     void print();
    
}

 class  cash implements  PaymentMode{
       public void print(){
         System.out.println("This ride was paid by cash");
       }
    
}

class  Online implements  PaymentMode{
    public void print(){
      System.out.println("This ride was paid by online ");
    }
 
}

abstract class factory_pay{
     abstract PaymentMode getInstance(String str);
}
//abstract factory 
class onlinefactory extends factory_pay{
   public  PaymentMode getInstance(String str){
    if(str.equalsIgnoreCase("online")){
        return new Online();
    }
   
    return null;
   }
}
/**
 * cashFactory
 */
 class cashFactory extends factory_pay {
    public  PaymentMode getInstance(String str){
        if(str.equalsIgnoreCase("cash")){
            return new cash();
        }
        return null;
    }
    
}

