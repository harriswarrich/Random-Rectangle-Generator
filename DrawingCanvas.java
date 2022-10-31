import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;

public class DrawingCanvas extends JComponent{
    private int width;
    private int height;
    //constructor to make JFrame
    public DrawingCanvas(int w, int h){
        width = w;
        height = h;
    }
    //Method to display valid rectangles on JFrame
    protected void paintComponent(Graphics g){
        //cast the Graphics object into a Graphics2D object
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(0 , 0, 900, 900);
        g2d.setColor(new Color(100, 149, 237));
        g2d.fill(r);
        boolean valid = false;
        int [] rectangle1 = null;
        int [] rectangle2 = null;
        //generates new rectangles until they meet requirements
        while(!valid){
            rectangle1 = generateRectangle(101);
            rectangle2 = generateRectangle(151);
            valid = areValid(rectangle1, rectangle2);
        }

        Rectangle2D.Double r1 = new Rectangle2D.Double(rectangle1[0], rectangle1[1], rectangle1[2], rectangle1[3]);
        g2d.setColor(new Color(0, 0, 255));
        g2d.fill(r1);


        Rectangle2D.Double r2 = new Rectangle2D.Double(rectangle2[0], rectangle2[1], rectangle2[2], rectangle2[3]);
        g2d.setColor(new Color(0, 0, 255));
        g2d.fill(r2);
    }

    //Method that starts generating random numbers and returns an array of coordinates
    private int [] generateRectangle(int bound){
        Random rand = new Random();
        int x, y, height, width;
        x = rand.nextInt(700);
        y = rand.nextInt(700);
        height = 50 + rand.nextInt(bound);
        width = 50 + rand.nextInt(bound);
        int [] coords = new int [4];
        coords[0] = x;
        coords[1] = y;
        coords[2] = height;
        width = height;
        coords[3] = width;
        return coords;
    }
    //Mthos to check if the rectangles generated are valid and meet all requirements
    private boolean areValid(int[] rect1, int[]rect2){
        //convert from [x,y,h,w] to [x1,y1,x2,y2]
        rect1 = convertToCords(rect1[0], rect1[1], rect1[2], rect1[3]);
        rect2 = convertToCords(rect2[0], rect2[1], rect2[2], rect2[3]);
        boolean noOverlap = !isRectangleOverlap(rect1, rect2);
        boolean inBounds = (!isOutOfBounds(rect1)) && !(isOutOfBounds(rect2));
        return noOverlap && inBounds;
    }

    //Method to check if rectangels overlap
    private boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec2[1] >= rec1[3]);
    }

    //Method given 1 rectangle, see if it is out of bounds
    private boolean isOutOfBounds(int[] rec1){
        for(int i = 0; i < 4; i++){
            if(rec1[i] >= 900 && rec1[i] < 0){
                return true;
            }
        }
        return false;
    }


    //Method to add points to an array
    private int [] convertToCords(int x, int y, int height, int width){
        int [] points = new int [4];
        points[0] = x;
        points[1] = y;
        points[2] = x + width;
        points[3] = y + height;
        return points;
    }   
}
