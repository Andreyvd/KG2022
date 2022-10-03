import java.awt.*;

public class Triangle {
    private static double X1;
    private static double Y1;
    private static double X2;
    private static double Y2;
    private static double X3;
    private static double Y3;
    private   static Color  A;
    private   static Color  B;
    private   static Color  C;

    public  double getX1() {
        return X1;
    }

    public  double getY1() {
        return Y1;
    }

    public  double getX2() {
        return X2;
    }

    public  double getY2() {
        return Y2;
    }

    public  double getX3() {
        return X3;
    }

    public  double getY3() {
        return Y3;
    }

    public  Color getA() {
        return A;
    }

    public  Color getC() { return C;  }

    public  Color getB() {
        return B;
    }


    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color left, Color right, Color up) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
        X3 = x3;
        Y3 = y3;
        A = up;
        B = left;
        C = right;

    }

    public Color colorRGB(int r,int g,int b){
        return new Color(r,g,b);
    }
}
