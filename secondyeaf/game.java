import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Gamestate g1 = Gamestate.getInstance();
        g1.setGamestate(12,4,"HARD");
        //gamestate
        System.out.println("scoure =" + g1.score );
        System.out.println("level =" + g1.currlevel );
        System.out.println("difficulty =" + g1.difficulty );

        Scanner sc = new Scanner(System.in);
        String Enemie_type = sc.nextLine();
        String Enemie = sc.nextLine();
        FactoryEnemies fe;
        Enemies e;
        if(Enemie_type.equalsIgnoreCase("Animal")){
         fe = new Animalfactory();
          e = fe.getInstance(Enemie);

        }
        else if(Enemie_type.equalsIgnoreCase("Robot")){
            fe = new Robotsfactory();
           e = fe.getInstance(Enemie);
           }
           else {
            e= null;
           }
           e.createEnemies();

        sc.close();
    }
}
interface Enemies{
   void createEnemies();
}
//Animal
class Animals  implements Enemies{
   public void createEnemies(){
        System.out.println("i am an animal");
    }
}
class Dragon extends Animals{
    public void createEnemies(){
        System.out.println("i am a dragon");
    }
}
class cow extends Animals{
    public void createEnemies(){
        System.out.println("i am a cow");
    }
}
//Robots
class Robots implements Enemies{
    public void createEnemies(){
        System.out.println("i am an robot");
    }
}
class Titans extends Robots{
    public void createEnemies(){
        System.out.println("i am a Titan");
    }
}
class Ai extends Robots{
    public void createEnemies(){
        System.out.println("i am a Ai");
    }
}
// Abstract factory 
abstract class FactoryEnemies{
    abstract Enemies getInstance(String str);
}
// Dragonfactory

class  Animalfactory extends FactoryEnemies {
    public Enemies getInstance(String str){
        if(str.equalsIgnoreCase("Dragon")){
            return new Dragon();
        }
        else if(str.equalsIgnoreCase("cow")){
            return new cow();
        }
        return null;
    }
    
}
// robotsfcatory
class  Robotsfactory extends FactoryEnemies {
    public Enemies getInstance(String str){
        if(str.equalsIgnoreCase("Titan")){
            return new Titans();
        }
        else if(str.equalsIgnoreCase("AI")){
            return new Ai();
        }
        return null;
    }
    
}





 class Gamestate {
     private static Gamestate g;
    public int score;
    public  int currlevel;
    public  String difficulty;
    
     private Gamestate(){

     }
   public void setGamestate(int s,int c,String d){
    this.currlevel =c;
    this.difficulty = d;
    this.score = s;

   }
   public static Gamestate getInstance(){
     if( g== null){
        g = new Gamestate();
     }
     return g;
   }


    
}
