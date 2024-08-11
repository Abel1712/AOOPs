
public class Q1 {
   

   public static void main(String[] args) {
    car c = new car("kia", 2024);
    System.out.println("the car is "+ c.brand +" "+c.year);
    car.startEngine();
    car.stopEngine();
   }
}
 class Vehicle{
    String  brand;
    int year;

    Vehicle(String b,int y){
        this.brand = b;
        this.year = y;
    }

    public static void startEngine(){
        System.out.println("the engine is on");
    }
    public static void stopEngine(){
        System.out.println("the engine is turned off");
    }
   }

    class car extends Vehicle{
        car(String b,int y){
            super(b,y);
        }
   }

