package GUI;

import CycleList.CycleList;
import Factory.UserFactory;
import Types.FloatType;
import Types.PointType;
import Types.Users.FloatUserType;
import Types.Users.PointUserType;
import Types.Users.UserType;

import javax.swing.*;
import java.util.ArrayList;

public class ActionListenerGUI implements ActionsListener{

    public UserFactory userFactory;
    public UserType userType;
    public CycleList cycleList;
    public ActionListenerGUI() {
        JFrame frame = new JFrame ("MainMenu");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GUI());
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);

        userFactory = new UserFactory();
        userType = userFactory.getBuilderByName("Float");
        cycleList = new CycleList(userType.getTypeComparator());

        ArrayList<String> typeNameList = userFactory.getTypeNameList();
        String[] factoryListItems = new String[typeNameList.size()];

        for (int i = 0; i < typeNameList.size(); i++) {
            factoryListItems[i] = typeNameList.get(i);
        }
//
//        FloatType int1 = (FloatType) floatUserType.parseValue("323.123");
//        System.out.println(int1.toString());
//
//        PointType int2 = (PointType) pointUserType.parseValue("(12.123;1.6)");
//        System.out.println(int2.toString());
//
//        CycleList cycleList = new CycleList();
    }

    @Override
    public void onAdd(String text) {

    }

    @Override
    public void onAddById(String text, int index) {

    }

    @Override
    public void onRemove(int index) {

    }

    @Override
    public void onSort() {

    }

    @Override
    public void onSave() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public DefaultListModel<Object> getListModel() {
        return null;
    }

    @Override
    public void onSelectType(String type) {

    }
}
