package Serialization;

import CycleList.CycleList;
import Factory.UserFactory;
import Types.Users.UserType;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Класс выполняющий сериализацию.
 * @see Serialization#saveToFile(String, CycleList, UserType) Метод сохранение в файл
 * @see Serialization#loadFromFile(String) Метод загрузки из файла
 */
public class Serialization implements Serializable {
    XMLStreamWriter writer;
    /**
     * Метод сохранения в файл
     * @param filename название файла, для сохранения
     * @param cycleList экземпляр циклического списка для дальнейшей сериализации
     * @throws IOException
     */
    public static void saveToFile(String filename, CycleList cycleList, UserType userType) throws IOException {
//        FileOutputStream fos = new FileOutputStream(filename);
//        ObjectOutputStream out = new ObjectOutputStream(fos);
//        out.writeObject(userType.typeName());
//        out.writeObject(cycleList.getLength());
//        cycleList.forEach(el -> {
//            try {
//                out.writeObject(el.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        out.close();

    }

    public static void serializeToXML(CycleList cycleList) throws IOException
    {
//        XMLStreamWriter
//        FileOutputStream fos = new FileOutputStream("settings.xml");
//        XMLEncoder encoder = new XMLEncoder(fos);
//        encoder.setExceptionListener(new ExceptionListener() {
//            public void exceptionThrown(Exception e) {
//                System.out.println("Exception! :"+e.toString());
//            }
//        });
//        encoder.writeObject(cycleList);
//        encoder.close();
//        fos.close();
    }

    public void writeActivity(CycleList cycleList){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try (FileWriter fileWriter = new FileWriter("myoutput.xml")) {
            writer = factory.createXMLStreamWriter(fileWriter);
            writer.writeStartDocument();
            writer.writeStartElement("userType");

        } catch (XMLStreamException | IOException e) {
            throw new RuntimeException(e);
        }

//        writer.writeStartElement("list");
//        writer.writeAttribute("length", String.valueOf(cycleList.getLength()));
//
//        writer.writeStartElement("node");
//
//        for(CycleList child : cycleList.getChildren()) {
//            cycleList.forEach(el -> {
//                try {
//                    writeActivity(el.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        writer.writeEndElement(); //ends element children
//
//        writer.writeEndElement(); //ends element activity
    }

    /**
     * Метод загрузки циклического списка из файла
     * @param filename название файла, для дальнейшей загрузки
     * @return cycleListLoading - циклический список
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static CycleList loadFromFile(String filename) throws IOException, ClassNotFoundException {
        CycleList cycleListLoading = null;
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        cycleListLoading = (CycleList) in.readObject();
        in.close();
        fileIn.close();
        return cycleListLoading;
    }
}
