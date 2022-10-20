package Comparator;

import Types.PointType;

public class PointComparator implements Comparator {
    @Override
    public float compare(Object o1, Object o2) {
        float firstX = ((PointType) o1).getX();
        float secondX = ((PointType) o2).getX();
        float firstY = ((PointType) o1).getY();
        float secondY = ((PointType) o2).getY();
        return getVectorLength(firstX, firstY) - getVectorLength(secondX, secondY);
    }

    public float getVectorLength(float x, float y){
        return (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
}
