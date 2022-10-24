package Testing;

import CycleList.CycleList;
import Factory.UserFactory;
import Types.Users.UserType;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
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


    private static String FLOAT_FILE_SAVE = "saveFloat.xml";
    private static String POINT_FILE_SAVE = "savePoint.xml";
    public void testFloatType() throws XMLStreamException, FileNotFoundException {
        userFactory = new UserFactory();
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

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("-----SAVE TO XML----");
        cycleList.save(userType, FLOAT_FILE_SAVE);

        System.out.println("\n----GET NODE BY INDEX 3, 4, 5, 6----");
        System.out.println("3) = " + cycleList.getByIndex(3).toString());
        System.out.println("4) = " + cycleList.getByIndex(3).toString());
        System.out.println("5) = " + cycleList.getByIndex(3).toString());
        System.out.println("6) = " + cycleList.getByIndex(3).toString());

        System.out.println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--");
        cycleList.remove(3);
        cycleList.remove(4);
        cycleList.remove(5);
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM XML----");
        cycleList.load(FLOAT_FILE_SAVE);
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);

        System.out.println("---------ITERATOR REVERSE-----------");
        cycleList.forEachReverse(System.out::println);
    }

    public void testPointType() throws IOException, XMLStreamException {
        userFactory = new UserFactory();
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

        System.out.println("---------PRINT CYCLE LIST---------");
        cycleList.printList();

        System.out.println("-----SAVE TO XML----");
        cycleList.save(userType, POINT_FILE_SAVE);

        System.out.println("\n----GET NODE BY INDEX 3, 4, 5, 6----");
        System.out.println("3) = " + cycleList.getByIndex(3).toString());
        System.out.println("4) = " + cycleList.getByIndex(3).toString());
        System.out.println("5) = " + cycleList.getByIndex(3).toString());
        System.out.println("6) = " + cycleList.getByIndex(3).toString());

        System.out.println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--");
        cycleList.remove(3);
        cycleList.remove(4);
        cycleList.remove(5);
        cycleList.remove(6);
        cycleList.printList();

        System.out.println("-----------SORTING----------");
        cycleList.sort(userType.getTypeComparator());
        cycleList.printList();

        System.out.println("---LOAD FROM XML----");
        cycleList.load(POINT_FILE_SAVE);
        cycleList.printList();

        System.out.println("---------ITERATOR-----------");
        cycleList.forEach(System.out::println);

        System.out.println("---------ITERATOR REVERSE-----------");
        cycleList.forEachReverse(System.out::println);
    }
}
