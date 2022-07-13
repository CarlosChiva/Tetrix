package Table;

import java.io.Serializable;

public class Point implements Serializable {
    int x_coordenade;
    int y_coordenade;
public Point(){
    this.x_coordenade=1;
    this.y_coordenade=6;
}
    public int getX_coordenade() {
        return x_coordenade;
    }

    public int getY_coordenade() {
        return y_coordenade;
    }

    public void setX_coordenade(int x_coordenade) {
        this.x_coordenade = x_coordenade;
    }

    public void setY_coordenade(int y_coordenade) {
        this.y_coordenade = y_coordenade;
    }
}
