import java.util.*;
import java.lang.*;

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r = in.nextDouble();
        double h= in.nextDouble();
        double V = Math.PI * r * r * h;
        System.out.printf("%.2f", V);
    }
}

