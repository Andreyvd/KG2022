import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;



public class Panel extends JFrame  {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 800;

    public Panel() {
        setTitle(" Drawing panel ");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        BufferedImage color = new BufferedImage(BACKGROUND_WIDTH,BACKGROUND_HEIGHT,BufferedImage.TYPE_INT_ARGB);
        for(int y = 0; y < BACKGROUND_HEIGHT; y++){
            for(int x = 0; x < BACKGROUND_WIDTH; x++){
                color.setRGB(x,y,getColor(x,y));}

        }

        g2d.drawImage(color,null,null);

    }

    public int getColor(int x, int y) {
        Triangle t = new Triangle(100,250,250,100,400,250,Color.red,Color.cyan,Color.MAGENTA);

        double l1, l2, l3;
        l1 = ((t.getY2() - t.getY3()) * ((double) x - t.getX3()) + (t.getX3() - t.getX2()) * ((double) y - t.getY3())) /
                ((t.getY2() - t.getY3()) * (t.getX1() - t.getX3()) + (t.getX3() - t.getX2()) * (t.getY1() - t.getY3()));

        l2 = ((t.getY3() - t.getY1()) * ((double) x - t.getX3()) + (t.getX1() - t.getX3()) * ((double) y - t.getY3())) /
                ((t.getY2() - t.getY3()) * (t.getX1() - t.getX3()) + (t.getX3() - t.getX2()) * (t.getY1() - t.getY3()));

        l3 = 1 - l1 - l2;

        int color = 0;

        if (l1 >= 0 && l1 <= 1 && l2 >= 0 && l2 <= 1 && l3 >= 0 && l3 <= 1) {

            int b = (t.colorRGB((int) (t.getB().getRed() * l1), (int) (t.getB().getGreen() * l1), (int) (t.getB().getBlue() * l1)).getRGB());
            int r = (t.colorRGB((int) (t.getA().getRed() * l2), (int) (t.getA().getGreen() * l2), (int) (t.getA().getBlue() * l2)).getRGB());
            int g = (t.colorRGB((int) (t.getC().getRed() * l3), (int) (t.getC().getGreen() * l3), (int) (t.getC().getBlue() * l3)).getRGB());
            color =  r + g + b;
       /* }if((l1 == 0 || l1 == 1) && (l2 == 0 || l2 == 1) && (l3 == 0 || l3 == 1) ){
             color =  Color.BLACK.getRGB();*/
        }
        return color;

    }
}
