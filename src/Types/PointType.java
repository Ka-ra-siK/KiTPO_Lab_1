package Types;

public class PointType {

    private float x;
    private float y;

    public PointType(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(this.x) +
                ";" + String.valueOf(this.y) + ")";
    }
}
