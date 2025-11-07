// java
package circlemanager;

import circlemanager.shape.Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(0, 0, 5, "红色");
        circle.howToColor();
    }
}
