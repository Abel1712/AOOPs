package prcatice;

public class lamda {
    public static void main(String[] args) {
      @SuppressWarnings("unused")
    Cat c1 = new Cat();
    //lamda expression 
    //   printThing(  () ->{
    //     System.out.println("meow");
    // }); 
    //   oR
    printable k = ()-> System.out.println("meow");
    printThing(k);
    }

    public static void printThing(printable p){
        p.print();
    }
}

 interface printable {
  void print();
}

class Cat implements printable{
    public void print(){
        System.out.println("meow");
    }
}
