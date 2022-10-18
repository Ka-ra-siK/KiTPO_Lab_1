package Comparator;

import Types.FloatType;

public class FloatComparator implements Comparator{
    @Override
    public float compare(Object o1, Object o2) {
        return ((FloatType)o1).getFloatTypeValue() - ((FloatType)o2).getFloatTypeValue();
    }
}
