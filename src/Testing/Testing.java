package Testing;

import CycleList.CycleList;
import Factory.UserFactory;
import Serialization.Serialization;
import Types.Users.UserType;

import java.io.IOException;

public class Testing {
    private UserFactory userFactory;
    private UserType userType;
    private CycleList cycleList;
    private Serialization serialization;

    private static String FLOAT_FILE_SAVE = "saveFloat.ser";
    private static String POINT_FILE_SAVE = "savePoint.ser";
    public void testFloatType() {
        userFactory = new UserFactory();
        serialization = new Serialization();
        System.out.println("--------------FLOAT-------------");
        userType = userFactory.getBuilderByName("Float");
        cycleList = new CycleList(userType.getTypeComparator());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("\n----GET NODE BY INDEX 3----");
        System.out.println("value = " + cycleList.getByIndex(3).toString());

        System.out.println("\n---DELETE NODE BY INDEX 6--");
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----SAVE IN BINARY FILE----");
        try {
            serialization.saveToFile(FLOAT_FILE_SAVE, cycleList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM BINARY FILE----");
        try {
            cycleList = serialization.loadFromFile(FLOAT_FILE_SAVE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cycleList.printList();

        System.out.println("---------FOR EACH-----------");
        cycleList.forEach(System.out::println);
    }

    public void testPointType() {
        userFactory = new UserFactory();
        serialization = new Serialization();
        System.out.println("--------------TEST FOR Point-------------");
        userType = userFactory.getBuilderByName("Point");
        cycleList = new CycleList(userType.getTypeComparator());

        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("\n----GET VALUE BY INDEX 3----");
        System.out.println("value = " + cycleList.getByIndex(3).toString());

        System.out.println("---DELETE VALUE BY INDEX 6--");
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----SAVE IN BINARY FILE----");
        try {
            serialization.saveToFile(POINT_FILE_SAVE, cycleList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM BINARY FILE----");
        try {
            cycleList = serialization.loadFromFile(POINT_FILE_SAVE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cycleList.printList();

        System.out.println("---------FOR EACH-----------");
        cycleList.forEach(System.out::println);
    }
}
