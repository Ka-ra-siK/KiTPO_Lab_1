package Comparator;

import Types.FloatType;

import java.io.Serializable;

/**
 * Сравнение объектов типа Float
 */
public class FloatComparator implements Comparator, Serializable {
    @Override
    public float compare(Object o1, Object o2) {
        return ((FloatType)o1).getFloatTypeValue() - ((FloatType)o2).getFloatTypeValue();
    }
}
