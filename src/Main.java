import GUI.GUI;
import Testing.Testing;

public class Main {
    public static void main(String[] args) {
        Testing test = new Testing();
        GUI gui = new GUI();
        test.testFloatType();
        test.testPointType();
        gui.showMenu();
    }
}


