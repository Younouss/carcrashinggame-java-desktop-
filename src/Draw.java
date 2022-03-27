
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Draw extends JFrame{
    public Draw(){
        setTitle("p7Younouss_T");
        setSize(700, 700);  
        Container contentPane = getContentPane(); 
        contentPane.setFocusable(false);
        add10 = new JButton("Add 10"); 
        add10.setFocusable(false);
        clearAll= new JButton("Clear All"); 
        clearAll.setFocusable(false);
        fixCar = new JButton("Fix Car");  
        fixCar.setFocusable(false);
        JPanel buttons = new JPanel();
        buttons.setFocusable(false);
        buttons.add(add10);
        buttons.add(clearAll);
        buttons.add(fixCar);    
        contentPane.add(buttons,"South");
        canvas = new DrawPanel(); 
        canvas.setFocusable(true);
        canvas.setBackground(Color.BLACK);
        contentPane.add(canvas,"Center");
        ActionListener buttonObserver = new ButtonObserver();      
        add10.addActionListener(buttonObserver);
        clearAll.addActionListener(buttonObserver);
        fixCar.addActionListener(buttonObserver);
        canvas.addKeyListener(new KeyController());
    }

    class ButtonObserver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
             Object source = e.getSource();
            if(source == add10){
                for(int i = 0; i < 5; i++){
                    Point2D.Double location = new Point2D.Double((Double) (Math.random() * canvas.getSize().width), (Double) (Math.random() * canvas.getSize().height));
                    Circle circle = new Circle(location, java.awt.Color.white, 20);
                    shapeList.add(circle);
                }
                for(int i = 0; i < 5; i++){
                    Point2D.Double location = new Point2D.Double((Double) (Math.random() * canvas.getSize().width), (Double) (Math.random() * canvas.getSize().height));
                    Square square = new Square(location, java.awt.Color.white, 20);
                    shapeList.add(square);
                }
                  collision();
                  canvas.repaint();
            }
            if(source == fixCar){
                car.fixCar();
                canvas.repaint();
            }
            if(source == clearAll){
                shapeList.removeAll(shapeList);
                 canvas.repaint();
            }
        }   
    }
    
    public class KeyController implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                car.moveLeft();
                collision();
                canvas.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                car.moveRight();
                collision();
                canvas.repaint();
                break;
            case KeyEvent.VK_UP:
                car.moveUp();
                collision();
                canvas.repaint();
                break;
            case KeyEvent.VK_DOWN:
                car.moveDown();
                collision();
                canvas.repaint();
                break;
        }
    }

        @Override
        public void keyTyped(KeyEvent ke) {
           
        }

        @Override
        public void keyReleased(KeyEvent ke) {
       
        }
    }
    private class DrawPanel extends JPanel { 
        @Override
        public void paintComponent(Graphics g) {  
             super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g; 
              for (MyShape shape :  shapeList) {     
              shape.draw(g2);
            }
            car.bottomBodyFront.draw(g2);
            car.bottomBodyRear.draw(g2);
            car.frontTire.draw(g2);
            car.rearTire.draw(g2);
            car.topBody.draw(g2);
        }
    }
    public void collision(){
        synchronized(shapeList){
         for (MyShape shape :  shapeList) {  
             if(shape.getCollisionBox().intersects(car.bottomBodyFront.getCollisionBox())){
                 shapeList.remove(shape);
                 car.breakBottomBodyFront();
                 canvas.repaint();
             }
              if(shape.getCollisionBox().intersects(car.bottomBodyRear.getCollisionBox())){
                 shapeList.remove(shape);
                 car.breakBottomBodyRear();
                 canvas.repaint();
             }         
              if(shape.getCollisionBox().intersects(car.frontTire.getCollisionBox())){
                 shapeList.remove(shape);
                 car.breakFrontTire();
                 canvas.repaint();
             }
               if(shape.getCollisionBox().intersects(car.rearTire.getCollisionBox())){
                 shapeList.remove(shape);
                 car.breakRearTire();
                 canvas.repaint();
             }             
               if(shape.getCollisionBox().intersects(car.topBody.getCollisionBox())){
                 shapeList.remove(shape);
                 car.breakTopBody();
                 canvas.repaint();
             }
             
         }
    }
    }
    JButton add10,clearAll,fixCar;
    DrawPanel canvas;
    CopyOnWriteArrayList<MyShape> shapeList = new CopyOnWriteArrayList<MyShape>();
    MyCar car = new MyCar();

}
