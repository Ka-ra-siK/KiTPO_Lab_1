package Testing;

import CycleList.CycleList;
import Factory.UserFactory;
import Serialization.Serialization;
import Types.Users.UserType;

import java.io.IOException;

/**
 * Класс для тестирования.
 * Вывод в консоль трасировки выполнения всех основных методов.
 * @see Testing#testFloatType() Тестирования Float
 * @see Testing#testPointType() Тестирование 2D-Точки
 */
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
        System.out.println("\n--------------TEST FOR FLOAT-------------");
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

        System.out.println("\n---DELETE NODE BY INDEX 3--");
        cycleList.remove(3);
        cycleList.printList();

        System.out.println("-----SAVE IN BINARY FILE----");
        try {
            serialization.saveToFile(FLOAT_FILE_SAVE, cycleList);
            System.out.println("Saving is successful!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM BINARY FILE----");
        try {
            cycleList = serialization.loadFromFile(FLOAT_FILE_SAVE);
            System.out.println("Loading is successful!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);
    }

    public void testPointType() {
        userFactory = new UserFactory();
        serialization = new Serialization();
        System.out.println("\n--------------TEST FOR 2D-POINT-------------");
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

        System.out.println("---DELETE VALUE BY INDEX 3--");
        cycleList.remove(3);
        cycleList.printList();

        System.out.println("-----SAVE IN BINARY FILE----");
        try {
            serialization.saveToFile(POINT_FILE_SAVE, cycleList);
            System.out.println("Saving is successful!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM BINARY FILE----");
        try {
            cycleList = serialization.loadFromFile(POINT_FILE_SAVE);
            System.out.println("Loading is successful!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);
    }
}
