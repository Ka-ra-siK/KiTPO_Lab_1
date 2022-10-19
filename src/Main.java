import CycleList.CycleList;
import Factory.UserFactory;
import Types.Users.FloatUserType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("It Works!");
        FloatUserType floatUserType = new FloatUserType();

        CycleList cycleList = new CycleList();
        cycleList.add(1.0);
        cycleList.add(2.0);
        cycleList.add(3.0);
        cycleList.add(4.0);
        cycleList.remove(0);

        //cycleList.remove(0);
        System.out.println("It Works!");
    }
}


