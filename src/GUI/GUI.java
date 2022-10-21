package GUI;

import CycleList.CycleList;
import Factory.UserFactory;
import Serialization.Serialization;
import Types.Users.UserType;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JPanel {
    private JButton findBtn;
    private JButton delBtn;
    private JButton insertByIdBtn;
    private JButton insertBtn;
    private JButton sortBtn;
    private JButton saveBtn;
    private JButton loadBtn;
    private JButton clearBtn;
    private JLabel findLabel;
    private JLabel delLabel;
    private JLabel typeLabel;
    private JLabel insertLabel;
    private JLabel createLabel;
    private JLabel sortLabel;
    private JTextArea outTextField;
    private JTextField findByIdField;
    private JTextField delByIdField;
    private JTextField insertByIdField;
    private JComboBox typeList;
    public UserFactory userFactory;
    public UserType userType;
    public CycleList cycleList;
    Serialization serialization;
    public String defaultType;

    public final String FILE_NAME = "CycleList.ser";

    public GUI() {
        defaultType = "Float";
        userFactory = new UserFactory();
        userType = userFactory.getBuilderByName(defaultType);
        cycleList = new CycleList(userType.getTypeComparator());
        serialization = new Serialization();

        ArrayList<String> typeNameList = userFactory.getTypeNameList();
        String[] factoryListItems = new String[typeNameList.size()];

        for (int i = 0; i < typeNameList.size(); i++) {
            factoryListItems[i] = typeNameList.get(i);
        }


        findBtn = new JButton("Найти");
        delBtn = new JButton("Удалить");
        insertByIdBtn = new JButton("Вставить");
        insertBtn = new JButton("Сгенерировать");
        sortBtn = new JButton("Сортировать");
        saveBtn = new JButton("Сохранить");
        loadBtn = new JButton("Загрузить");
        clearBtn = new JButton("Очистить");
        outTextField = new JTextArea(5, 5);
        typeList = new JComboBox(factoryListItems);
        findByIdField = new JTextField(5);
        findLabel = new JLabel("Поиск по индексу");
        delByIdField = new JTextField(5);
        delLabel = new JLabel("Удалить по индексу");
        typeLabel = new JLabel("Тип данных");
        insertLabel = new JLabel("Вставка по индексу");
        insertByIdField = new JTextField(5);
        createLabel = new JLabel("Сгенерировать данные");
        sortLabel = new JLabel("Сортировка");


        //set components properties
        outTextField.setEnabled(true);
        outTextField.setFont(new Font("Arial", Font.BOLD, 14));

        //adjust size and set layout
        setPreferredSize(new Dimension(600, 563));
        setLayout(null);

        //add components
        add(findBtn);
        add(delBtn);
        add(insertByIdBtn);
        add(outTextField);
        add(typeList);
        add(findByIdField);
        add(findLabel);
        add(delByIdField);
        add(delLabel);
        add(typeLabel);
        add(insertLabel);
        add(insertByIdField);
        add(insertBtn);
        add(createLabel);
        add(sortLabel);
        add(sortBtn);
        add(saveBtn);
        add(loadBtn);
        add(clearBtn);

        findBtn.setBounds(25, 135, 150, 25);
        delBtn.setBounds(25, 220, 150, 25);
        insertByIdBtn.setBounds(25, 315, 150, 25);
        outTextField.setBounds(190, 20, 345, 525);
        typeList.setBounds(25, 50, 150, 25);
        findByIdField.setBounds(25, 105, 150, 25);
        findLabel.setBounds(25, 85, 150, 20);
        delByIdField.setBounds(25, 190, 150, 25);
        delLabel.setBounds(25, 165, 150, 25);
        typeLabel.setBounds(25, 20, 150, 25);
        insertLabel.setBounds(25, 255, 150, 25);
        insertByIdField.setBounds(25, 280, 150, 25);
        insertBtn.setBounds(25, 435, 150, 20);
        createLabel.setBounds(25, 405, 145, 25);
        sortLabel.setBounds(25, 350, 100, 25);
        sortBtn.setBounds(25, 375, 150, 25);
        saveBtn.setBounds(25, 465, 150, 20);
        loadBtn.setBounds(25, 490, 150, 20);
        clearBtn.setBounds(25, 520, 150, 25);

        findBtn.addActionListener(e -> findNodeById());
        delBtn.addActionListener(e -> deleteNodeById());
        insertByIdBtn.addActionListener(e -> addNodeById());

        insertBtn.addActionListener(e -> addNode());

        sortBtn.addActionListener(e -> sortList());
        saveBtn.addActionListener(e -> saveList());
        loadBtn.addActionListener(e -> loadList());
        clearBtn.addActionListener(e -> clearOutTextField());
        typeList.addActionListener(e -> selectTypeList(e));
    }

    public void showMenu() {
        JFrame frame = new JFrame("MainMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }


    private void selectTypeList(ActionEvent actionEvent) {
        JComboBox box = (JComboBox) actionEvent.getSource();
        String item = (String) box.getSelectedItem();
        if (defaultType != item) {
            defaultType = item;
            userType = userFactory.getBuilderByName(defaultType);
            cycleList = new CycleList(userType.getTypeComparator());
            setTextOnOutTextField();
        }
    }

    private void addNode() {
        cycleList.add(userType.create());
        setTextOnOutTextField();

    }

    private void addNodeById() {
        if (insertByIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!");
            return;
        }
        cycleList.add(userType.create(), Integer.parseInt(insertByIdField.getText()));
        setTextOnOutTextField();
        //TODO обработка исключений при вставке неправильного индекса (вызодящего за размер списка)
    }

    private void deleteNodeById() {
        if (delByIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!");
            return;
        }
        cycleList.remove(Integer.parseInt(delByIdField.getText()));
        setTextOnOutTextField();
        //TODO обработка исключений при удалении неправильного индекса (вызодящего за размер списка)
    }

    private void sortList() {
        cycleList.sort(userType.getTypeComparator());
        setTextOnOutTextField();
    }

    private void findNodeById() {
        if (findByIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Найденное значение: " +
                cycleList.getByIndex(Integer.parseInt(findByIdField.getText())));
    }

    private void saveList() {
        try {
            serialization.saveToFile(FILE_NAME, cycleList);
            JOptionPane.showMessageDialog(null, "Список успешно сохранен в \"" + FILE_NAME + "\"!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadList() {
        try {
            cycleList = serialization.loadFromFile(FILE_NAME);
            JOptionPane.showMessageDialog(null, "Список успешно загружен!");
            setTextOnOutTextField();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearOutTextField() {
        cycleList = new CycleList(userType.getTypeComparator());
        setTextOnOutTextField();
    }

    private void setTextOnOutTextField() {
        outTextField.setText(cycleList.toString());
    }
}
