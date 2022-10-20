package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JPanel {
    private JButton findBtn;
    private JButton delBtn;
    private JButton insertBtn;
    private JTextArea outTextField;
    private JComboBox typeList;
    private JTextField findById;
    private JLabel findLabel;
    private JTextField delById;
    private JLabel delLabel;
    private JLabel typeLabel;
    private JLabel insertLabel;
    private JTextField insertById;
    private JButton createBtn;
    private JLabel createLabel;
    private JLabel sortLabel;
    private JButton sortBtn;
    private JButton saveBtn;
    private JButton jcomp18;
    private JButton loadBtn;
    private JButton clearBtn;

    public GUI() {
        //construct preComponents
        String[] typeListItems = {"Float", "Point"};

        //construct components
        findBtn = new JButton("Найти");
        delBtn = new JButton("Удалить");
        insertBtn = new JButton("Вставить");
        outTextField = new JTextArea(5, 5);
        typeList = new JComboBox(typeListItems);
        findById = new JTextField(5);
        findLabel = new JLabel("Поиск по индексу");
        delById = new JTextField(5);
        delLabel = new JLabel("Удалить по индексу");
        typeLabel = new JLabel("Тип данных");
        insertLabel = new JLabel("Вставка по индексу");
        insertById = new JTextField(5);
        createBtn = new JButton("Сгенерировать");
        createLabel = new JLabel("Сгенерировать данные");
        sortLabel = new JLabel("Сортировка");
        sortBtn = new JButton("Сортировать");
        saveBtn = new JButton("Сохранить");
        jcomp18 = new JButton("Загрузка");
        loadBtn = new JButton("Загрузить");
        clearBtn = new JButton("Очистить");

        //set components properties
        outTextField.setEnabled(false);

        //adjust size and set layout
        setPreferredSize(new Dimension(944, 563));
        setLayout(null);

        //add components
        add(findBtn);
        add(delBtn);
        add(insertBtn);
        add(outTextField);
        add(typeList);
        add(findById);
        add(findLabel);
        add(delById);
        add(delLabel);
        add(typeLabel);
        add(insertLabel);
        add(insertById);
        add(createBtn);
        add(createLabel);
        add(sortLabel);
        add(sortBtn);
        add(saveBtn);
        add(jcomp18);
        add(loadBtn);
        add(clearBtn);

        findBtn.setBounds(25, 135, 150, 25);
        delBtn.setBounds(25, 220, 150, 25);
        insertBtn.setBounds(25, 315, 150, 25);
        outTextField.setBounds(190, 20, 735, 530);
        typeList.setBounds(25, 50, 150, 25);
        findById.setBounds(25, 105, 150, 25);
        findLabel.setBounds(25, 85, 150, 20);
        delById.setBounds(25, 190, 150, 25);
        delLabel.setBounds(25, 165, 150, 25);
        typeLabel.setBounds(25, 20, 150, 25);
        insertLabel.setBounds(25, 255, 150, 25);
        insertById.setBounds(25, 280, 150, 25);
        createBtn.setBounds(25, 435, 150, 20);
        createLabel.setBounds(25, 405, 145, 25);
        sortLabel.setBounds(25, 350, 100, 25);
        sortBtn.setBounds(25, 375, 150, 25);
        saveBtn.setBounds(25, 465, 150, 20);
        jcomp18.setBounds(95, 620, 60, 40);
        loadBtn.setBounds(25, 490, 150, 20);
        clearBtn.setBounds(25, 520, 150, 25);
    }
}
