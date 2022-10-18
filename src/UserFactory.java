import Types.Users.FloatUserType;
import Types.Users.PointUserType;
import Types.Users.UserType;

import java.util.ArrayList;
//TODO Додлеать фабрику

public class UserFactory {
    public ArrayList<String> getTypeNameList() {
        return null;
    }

    public UserType getBuilderByName(String name) {
        switch(name) {
            case "Float":
            {
                return new FloatUserType();
            }
            case "2D Point":
            {
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
