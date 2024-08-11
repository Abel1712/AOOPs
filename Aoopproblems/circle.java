public class    circle implements shape{
    public void draw(){
        System.out.println("I am drawing a circle");
    }
    public void getArea(){
        System.out.println("the area of circle is ¶*r^2");
    }

    public static void main(String[] args) {
       circle c = new circle();
       c.draw();
       c.getArea(); 
    }
}
interface  shape{
    public void draw ();
    public void getArea();
}