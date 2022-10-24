import CycleList.CycleList;
import Factory.UserFactory;
import GUI.GUI;
import Serialization.Serialization;
import Testing.Testing;
import Types.Users.UserType;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
//        Testing test = new Testing();
//        //GUI gui = new GUI();
//        //test.testFloatType();
//        test.testPointType();
        //test.testPointType();
        //gui.showMenu();

        UserFactory userFactory;
        UserType userType;
        CycleList cycleList;
        userFactory = new UserFactory();
//        //serialization = new Serialization();
        userType = userFactory.getBuilderByName("Float");
        cycleList = new CycleList(userType.getTypeComparator());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.add(userType.create());
        cycleList.printList();
        cycleList.save(userType, cycleList);
        System.out.println("REMOVE");
        cycleList.remove(2);
        cycleList.printList();
        System.out.println("LOAD");
        cycleList.load();
        cycleList.printList();
        System.out.println("Huy");
//        cycleList.add(5, 3);
//        cycleList.remove(3);
//        System.out.println("It works!");
    }
}


