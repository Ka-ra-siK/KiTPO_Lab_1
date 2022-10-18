package CycleList;

public interface CycleList {
    void add(float data);
    float get(int index);
    void remove(int index);
    int size();
    void add(float data, int index);
   //void forEach(Action<float> a);
    //void sort(Comparator<T> comparator);
}
