import CycleList.CycleList;
import Factory.UserFactory;
import GUI.GUI;
import Testing.Testing;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        Testing test = new Testing();
        GUI gui = new GUI();
        test.testFloatType();
        test.testPointType();
        gui.showMenu();
    }
}


