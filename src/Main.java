import CycleList.CycleList;
import Factory.UserFactory;
import Types.Users.FloatUserType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("It Works!");
        FloatUserType floatUserType = new FloatUserType();

        CycleList cycleList = new CycleList();
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.add(floatUserType.create());
        cycleList.printList();
        //cycleList.sort(floatUserType.getTypeComparator());
        System.out.println();
        cycleList.printList();

        //cycleList.remove(0);
        System.out.println("It Works!");
    }
}


