package Serialization;

import CycleList.CycleList;

import java.io.*;

/**
 * Класс выполняющий сериализацию.
 * @see Serialization#saveToFile(String, CycleList) Метод сохранение в файл
 * @see Serialization#loadFromFile(String) Метод загрузки из файла
 */
public class Serialization implements Serializable {
    /**
     * Метод сохранения в файл
     * @param filename название файла, для сохранения
     * @param cycleList экземпляр циклического списка для дальнейшей сериализации
     * @throws IOException
     */
    public static void saveToFile(String filename, CycleList cycleList) throws IOException {
        FileOutputStream outputStream = null;
        ObjectOutputStream outFile = null;
        outputStream = new FileOutputStream(filename);
        outFile = new ObjectOutputStream(outputStream);
        outFile.writeObject(cycleList);
        outputStream.close();
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
