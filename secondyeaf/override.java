public class override {
    
        public static void main(String[] args) {
            dog d = new dog();
            d.makeSound();
        }
    }
    
    class animal{
        public void makeSound(){
            System.out.println("animal makes sound");
        }
    }
    class dog extends animal{
        public void makeSound(){
            System.out.println("dog barks");
        }
    }

