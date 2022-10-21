package Types;

import java.io.Serializable;

public class FloatType implements Serializable {
    private float floatTypeValue;

    public FloatType(float floatTypeValue) {
        this.floatTypeValue = floatTypeValue;
    }

    public float getFloatTypeValue() {
        return this.floatTypeValue;
    }

    public void setFloatTypeValue(float floatTypeValue) {
        this.floatTypeValue = floatTypeValue;
    }

    @Override
    public String toString() {
        return String.valueOf(floatTypeValue);
    }


}
