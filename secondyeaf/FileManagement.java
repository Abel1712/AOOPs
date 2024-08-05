import java.util.*;
public class FileManagement {
   public static void main(String[] args) {
    FileSystem f1 = new File("A.txt");
    FileSystem f2 = new File("A.txt");
    FileSystem f3 = new File("A.txt");
    
    FileSystem d1 = new Directory("dir1");
   try{
    d1.add(f1);
    d1.add(f2);
    d1.add(f3);
    d1.display();
    d1.remove(f2);
    d1.display();
    f1.display();
   }
   catch(Cexception exp){
     System.err.println(exp.getMessage());
   }

   }


}

/**
 *  FileSystem
 */
 interface  FileSystem {
 void add(FileSystem i) throws Cexception;
 void display();
 void remove(FileSystem obj) throws Cexception;

}
class Cexception extends Exception {
    public Cexception(String message) {
        super(message);
    }
}

//file
class File implements FileSystem {
    private String str;

//set file name
  File(String str){
        this.str = str;
    }

    @Override
    public void remove(FileSystem obj) throws Cexception{
         throw new Cexception("Cannot delet from file");
    }

    public void display(){
          System.out.println("filename = " + str);
    }

   public  void add(FileSystem file) throws Cexception{
    throw new Cexception("Cannot delet from file");
}
    }

//directory
class Directory implements FileSystem{
    ArrayList <FileSystem> dir = new ArrayList<>();
     String name ;
    Directory(String name){
       this.name = name;
    }

    public void add(FileSystem file){
        dir.add(file);
    }

    public void remove(FileSystem file) {
        dir.remove(file);
    }

    public void display(){
        System.out.println("dir name = " + name);
        for (FileSystem fs : dir) {
            fs.display();  // Call display on each FileSystem item
        }
    }
}
