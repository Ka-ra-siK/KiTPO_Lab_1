package Types.Users;

import Comparator.Comparator;
import Comparator.FloatComparator;
import Types.FloatType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FloatUserType implements UserType{

    private final float MAX = 1000.0f;
    private final float MIN = -1000.0f;

    @Override
    public String typeName() {
        return "Float";
    }

    @Override
    public Object create() {
        Random random = new Random();
        FloatType floatTypeValue = new FloatType(random.nextFloat((MAX - MIN)) + MIN);
        return floatTypeValue;
    }

    @Override
    public Object clone(Object object) {
        FloatType copyFloatTypeValue = new FloatType(((FloatType)object).getFloatTypeValue());
        return copyFloatTypeValue;
    }

    @Override
    public Object readValue(InputStreamReader in) {
        try {
            return in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object parseValue(String floatString) {
        return Float.parseFloat(floatString);
    }

    @Override
    public Comparator getTypeComparator() {
        Comparator comparator = new FloatComparator();
        return comparator;
    }
}
