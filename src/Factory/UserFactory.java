package Factory;

import Types.Users.FloatUserType;
import Types.Users.PointUserType;
import Types.Users.UserType;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Класс - фабрика.
 * Возвращает класс по названию типа данных.
 */
public class UserFactory {
    private final static ArrayList<UserType> typeNameList = new ArrayList<>();

    static {
        ArrayList<UserType> buildersClasses = new ArrayList<>(Arrays.asList(new FloatUserType(), new PointUserType()));
        buildersClasses.forEach(userType -> typeNameList.add(userType));
    }
    public static Set<String> getTypeNameList() {
        return typeNameList.stream().map(UserType::typeName).collect(Collectors.toSet());
    }
    public static UserType getBuilderByName(String name){
        if (name == null){
            throw new RuntimeException("Error! Name of type is empty!");
        }
        for (UserType userType : typeNameList) {
            if (name.equals(userType.typeName()))
                return userType;
        }
        return null;
    }
}
