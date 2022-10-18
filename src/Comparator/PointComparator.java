package Comparator;
//TODO додлеть компаратор
//TODO написать структуру данных
//TODO сделать GUI
import Types.PointType;

/**
 *
 */
public class PointComparator implements Comparator{
    @Override
    public float compare(Object o1, Object o2) {
        float firstX = ((PointType)o1).getX();
        float secondX = ((PointType)o2).getX();
        float firstY = ((PointType)o1).getY();
        float secondY = ((PointType)o2).getY();

        if (firstX != secondX) {
            return firstX - secondX;
        }
        if (firstY != secondY) {
            return firstX - secondX;
        }
        return 0;
    }
}
