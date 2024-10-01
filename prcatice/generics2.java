package prcatice;


public class generics2 {
    public static void main(String [] args){
    Dog d = new Dog("bob");
     Cat c = new Cat("mat");

     printer <Dog> dp = new printer<>(d);
     printer <Cat> cp = new printer<>(c);

     dp.print();
     cp.print();
       shout(123);
       shout("hi how are u superman");
    }
    public static <t> void shout(t thing){
        System.out.println(thing + " !!!!! ");
    }
}
 class Animal{
    String name;
    Animal(){

    }
    Animal(String n){
        name = n;
    }
  public  String print(){
       return "my name is " + name ;
    }

 }
 class Dog extends Animal{
    Dog(String n){
        super(n);
    }
       public  String print(){
            return super.print() + "  i  am a dog ";
        }
 }

 class Cat extends Animal{
    Cat(String c){
        super(c);
    }
    public  String print(){
         return super.print() + " i am a cat ";
     }
}
class printer <T extends Animal>{
    T thing;
    
    printer(T A){
        this.thing = A;
    }
    void print(){
        System.out.println(thing.print());
    }
}

