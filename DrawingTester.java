import javax.swing.*;

public class DrawingTester {
    public static void main(String[] args) throws Exception {
        int w = 1300;
        int h = 1300;
        JFrame f = new JFrame();
        DrawingCanvas dc = new DrawingCanvas(w, h);
        f.setSize(w, h);
        f.setTitle("Collision Free Rectangles");
        f.add(dc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
