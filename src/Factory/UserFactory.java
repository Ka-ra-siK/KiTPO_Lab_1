package Factory;

import Types.Users.FloatUserType;
import Types.Users.PointUserType;
import Types.Users.UserType;

import java.util.ArrayList;

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
