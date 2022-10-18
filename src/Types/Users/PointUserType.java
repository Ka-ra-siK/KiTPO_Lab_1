package Types.Users;

import Comparator.Comparator;
import Comparator.PointComparator;
import Types.PointType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class PointUserType implements UserType{

    private final float MAX = 10.0F;
    private final float MIN = -10.0F;

    @Override
    public String typeName() {
        return "2D Point";
    }

    @Override
    public Object create() {
        Random random = new Random();
        float x = random.nextFloat(MAX - MIN) + MIN;
        float y = random.nextFloat(MAX - MIN) + MIN;
        PointType pointTypeValue = new PointType(x, y);
        return pointTypeValue;
    }

    @Override
    public Object clone(Object object) {
        PointType copyPointTypeValue = new PointType(((PointType)object).getX(), ((PointType)object).getY());
        return copyPointTypeValue;
    }

    @Override
    public Object readValue(InputStreamReader in){
        try {
            return in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object parseValue(String pointString) {
        //TODO дописать парсер
        return Float.parseFloat(pointString);
    }

    @Override
    public Comparator getTypeComparator() {
        Comparator comparator = new PointComparator();
        return comparator;
    }
}
