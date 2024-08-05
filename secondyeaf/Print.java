public class Print implements printable , scannable {
   
        public static void main(String[] args) {
            Print ps = new Print();
            ps.print();
            ps.scan();
        }
        public void scan(){
            System.out.println("scannning");
        }
        public void print(){
            System.out.println("printing");
        }
    }
    
    interface printable{
        public void print();
    }
    
    interface scannable{
        public void scan();
    }

