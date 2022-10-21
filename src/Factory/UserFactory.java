package Factory;

import Types.Users.FloatUserType;
import Types.Users.PointUserType;
import Types.Users.UserType;

import java.util.ArrayList;

/**
 * Класс - фабрика.
 * Возвращает класс по названию типа данных.
 * @see UserFactory#getTypeNameList() Метод получения динамичесого массива названий типов данных
 * @see UserFactory#getBuilderByName(String) Метод получения пользовательского типа данных
 */
public class UserFactory {
    public ArrayList<String> getTypeNameList() {
        ArrayList<String> typeNameList = new ArrayList<>();
        typeNameList.add("Float");
        typeNameList.add("Point");
        return typeNameList;
    }

    public UserType getBuilderByName(String name) {
        switch (name) {
            case "Float": {
                return new FloatUserType();
            }
            case "Point": {
                return new PointUserType();
            }
            default:
                try {
                    throw new Exception("Error! Can't find type by name!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }
}
