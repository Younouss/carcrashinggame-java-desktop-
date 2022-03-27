
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Circle extends MyShape {
Rectangle2D.Double square = new Rectangle2D.Double();
    public Circle(Point2D.Double location, Color color, int size) {
        super(location, color, size);
         square.setFrameFromCenter(super.getLocation().getX(), super.getLocation().getY(), super.getLocation().getX()- super.getSize()*0.9/2, super.getLocation().getY()- super.getSize()*0.9/2);
    }
    @Override
    public void draw(Graphics2D g2) {
      double x = super.getLocation().getX()- super.getSize()/2;
        double y = super.getLocation().getY()- super.getSize()/2;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, super.getSize(), super.getSize());
        g2.setColor(super.getColor());
        g2.draw(circle);
        g2.fill(circle);        
    }

    @Override
    public Rectangle2D.Double getCollisionBox() {
        return square;
    }
}   

