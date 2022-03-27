
import java.awt.Color;
import java.awt.geom.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Younouss
 */
public class MyCar {
   Circle frontTire;
   Circle rearTire;
   Square bottomBodyFront;
   Square bottomBodyRear;
   Square topBody; 
   final Color normalColor = Color.YELLOW;
   final Color brokenColor = Color.RED;
   private final int DISTANCE = 10;
   public MyCar(){
       bottomBodyFront = new Square(new Point2D.Double(45, 45),  normalColor, 30);
       bottomBodyRear = new Square(new Point2D.Double(15, 45), normalColor, 30);
       topBody = new Square(new Point2D.Double(30, 15), normalColor, 30);
       frontTire = new Circle(new Point2D.Double(45, 70), normalColor, 20);
       rearTire = new Circle(new Point2D.Double(15, 70), normalColor, 20);
}
   public void moveLeft(){
       bottomBodyFront = new Square(new Point2D.Double(bottomBodyFront.getLocation().getX() - DISTANCE, bottomBodyFront.getLocation().getY()),  bottomBodyFront.getColor(), 30);
       bottomBodyRear = new Square(new Point2D.Double(bottomBodyRear.getLocation().getX() - DISTANCE, bottomBodyRear.getLocation().getY()), bottomBodyRear.getColor(), 30);
       topBody = new Square(new Point2D.Double(topBody.getLocation().getX() - DISTANCE, topBody.getLocation().getY()), topBody.getColor(), 30);
       frontTire = new Circle(new Point2D.Double(frontTire.getLocation().getX() - DISTANCE , frontTire.getLocation().getY()), frontTire.getColor(), 20);
       rearTire = new Circle(new Point2D.Double(rearTire.getLocation().getX() - DISTANCE, rearTire.getLocation().getY()), rearTire.getColor(), 20);
   }
     public void moveRight(){
       bottomBodyFront = new Square(new Point2D.Double(bottomBodyFront.getLocation().getX() + DISTANCE, bottomBodyFront.getLocation().getY()),  bottomBodyFront.getColor(), 30);
       bottomBodyRear = new Square(new Point2D.Double(bottomBodyRear.getLocation().getX() + DISTANCE, bottomBodyRear.getLocation().getY()), bottomBodyRear.getColor(), 30);
       topBody = new Square(new Point2D.Double(topBody.getLocation().getX() + DISTANCE, topBody.getLocation().getY()), topBody.getColor(), 30);
       frontTire = new Circle(new Point2D.Double(frontTire.getLocation().getX() + DISTANCE , frontTire.getLocation().getY()), frontTire.getColor(), 20);
       rearTire = new Circle(new Point2D.Double(rearTire.getLocation().getX() + DISTANCE, rearTire.getLocation().getY()), rearTire.getColor(), 20);
   }
      public void moveUp(){
       bottomBodyFront = new Square(new Point2D.Double( bottomBodyFront.getLocation().getX(),  bottomBodyFront.getLocation().getY() - DISTANCE),   bottomBodyFront.getColor(), 30);
       bottomBodyRear = new Square(new Point2D.Double(bottomBodyRear.getLocation().getX(), bottomBodyRear.getLocation().getY() - DISTANCE),  bottomBodyRear.getColor(), 30);
       topBody = new Square(new Point2D.Double(topBody.getLocation().getX(), topBody.getLocation().getY() - DISTANCE),topBody.getColor(), 30);
       frontTire = new Circle(new Point2D.Double(frontTire.getLocation().getX(), frontTire.getLocation().getY() - DISTANCE), frontTire.getColor(), 20);
       rearTire = new Circle(new Point2D.Double(rearTire.getLocation().getX(), rearTire.getLocation().getY() - DISTANCE),rearTire.getColor(), 20);
   }
     public void moveDown(){
       bottomBodyFront = new Square(new Point2D.Double(bottomBodyFront.getLocation().getX(), bottomBodyFront.getLocation().getY() + DISTANCE),   bottomBodyFront.getColor(), 30);
       bottomBodyRear = new Square(new Point2D.Double(bottomBodyRear.getLocation().getX(), bottomBodyRear.getLocation().getY() + DISTANCE),  bottomBodyRear.getColor(), 30);
       topBody = new Square(new Point2D.Double(topBody.getLocation().getX(), topBody.getLocation().getY() + DISTANCE),topBody.getColor(), 30);
       frontTire = new Circle(new Point2D.Double(frontTire.getLocation().getX(), frontTire.getLocation().getY() + DISTANCE), frontTire.getColor(), 20);
       rearTire = new Circle(new Point2D.Double(rearTire.getLocation().getX(), rearTire.getLocation().getY()+ DISTANCE), rearTire.getColor(), 20);
   }
   public void breakBottomBodyFront (){
       bottomBodyFront = new Square(new Point2D.Double( bottomBodyFront.getLocation().getX(),  bottomBodyFront.getLocation().getY()),  brokenColor, 30);
   }
    public void breakBottomBodyRear (){
       bottomBodyRear = new Square(new Point2D.Double( bottomBodyRear.getLocation().getX(),  bottomBodyRear.getLocation().getY()),  brokenColor, 30);
   }
    public void breakTopBody (){
       topBody = new Square(new Point2D.Double( topBody.getLocation().getX(),  topBody.getLocation().getY()),  brokenColor, 30);
   }
    public void breakFrontTire (){
       frontTire = new Circle(new Point2D.Double( frontTire.getLocation().getX(),  frontTire.getLocation().getY()),  brokenColor, 20);
   }  
   public void breakRearTire (){
       rearTire = new Circle(new Point2D.Double( rearTire.getLocation().getX(),  rearTire.getLocation().getY()),  brokenColor, 20);
   }  
   public void fixCar(){
        bottomBodyFront = new Square(new Point2D.Double( bottomBodyFront.getLocation().getX(),  bottomBodyFront.getLocation().getY()),  normalColor, 30);
        bottomBodyRear = new Square(new Point2D.Double( bottomBodyRear.getLocation().getX(),  bottomBodyRear.getLocation().getY()),  normalColor, 30);
        topBody = new Square(new Point2D.Double( topBody.getLocation().getX(),  topBody.getLocation().getY()),  normalColor, 30);
        frontTire = new Circle(new Point2D.Double( frontTire.getLocation().getX(),  frontTire.getLocation().getY()),  normalColor, 20);
        rearTire = new Circle(new Point2D.Double( rearTire.getLocation().getX(),  rearTire.getLocation().getY()),  normalColor, 20);
   }  
}
