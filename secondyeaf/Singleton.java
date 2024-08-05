public class Singleton {
    public static void main(String[] args) {
        Single s = Single.getInstance();
        s.print();
    }
}


 class Single {
     private static Single s = new Single();

   private  Single(){
         
     }
    
    public static Single getInstance(){
        return s;
        /* static cause we want it to be associated with the class ,hence since the 
        object is also private & static along with the constructor being private  
        only one object can be created
        */ 
    }

    public  void print(){
        System.out.println("hi  iiiiiiii am u ");
    }
}