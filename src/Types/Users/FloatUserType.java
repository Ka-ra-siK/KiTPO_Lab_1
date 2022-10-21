package Types.Users;

import Comparator.Comparator;
import Comparator.FloatComparator;
import Types.FloatType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Интерфейс для создания объектов,
 * вещественное число.
 * @see UserType#typeName() Получение имя типа
 * @see UserType#create() Создание объекта
 * @see UserType#clone(Object) Клонирование текущего объекта
 * @see UserType#readValue(InputStreamReader) Чтение объекта
 * @see UserType#parseValue(String) Парсинг содержимого из стоки, с помощью регулярных выражений
 * @see UserType#getTypeComparator() Получение экземпляра компаратора
 */
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
        return new FloatType(Float.parseFloat(floatString));
    }

    @Override
    public Comparator getTypeComparator() {
        Comparator comparator = new FloatComparator();
        return comparator;
    }
}
