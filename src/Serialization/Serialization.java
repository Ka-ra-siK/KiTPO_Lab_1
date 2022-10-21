package Serialization;

import CycleList.CycleList;

import java.io.*;

public class Serialization implements Serializable {
    public static void saveToFile(String filename, CycleList cycleList) throws IOException {
        FileOutputStream outputStream = null;
        ObjectOutputStream outFile = null;
        outputStream = new FileOutputStream(filename);
        outFile = new ObjectOutputStream(outputStream);
        outFile.writeObject(cycleList);
        outputStream.close();
    }

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
