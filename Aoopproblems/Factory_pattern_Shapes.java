import java.util.Scanner;

public class Factory_pattern_Shapes {
    public static void main(String[] args) {
        factory f =new factory();
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();

        Shape s = f.getShapeInstance(str);
        s.getShape();
        sc.close();
    }
}

interface Shape{
     void getShape();
}
 
  class Circle implements Shape{
   public void getShape(){
       System.out.println(" I never end : I am a circle");
   }
    
 }
  
class Square implements Shape  {
  
    public void getShape(){
        System.out.println("I am the perfect representation of equality");
    }
  }
  
  // factory method
  class factory{
       public Shape getShapeInstance(String str){
           if(str.equalsIgnoreCase("Square")){
            return new Square();
           }
           else if(str.equalsIgnoreCase("circle")){
            return new Circle();
           }
           return null;
       }
  }

