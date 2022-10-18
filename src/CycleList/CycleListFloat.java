package CycleList;

import org.w3c.dom.Node;

public class CycleListFloat implements CycleList{
    private Node head;
    private Node tail;
    private int length;

    @Override
    public void add(float data) {
//       // Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//        } else {
//            tail.next = newNode;
//        }
//        tail = newNode;
//        tail.nextNode = head;
//        length++;
    }

    @Override
    public float get(int index) {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(float data, int index) {

    }
    private Object getNode(int index) {
//        if (index < 0 || index >= length);
//        Node tmp = head;
//
//        for (int i = 0; i < index; i++) {
//            tmp = tmp.nextNode;
//        }
        return 0;
    }
}
