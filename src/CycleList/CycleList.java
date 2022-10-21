package CycleList;

import Comparator.Comparator;

import java.io.Serializable;
import java.util.ArrayList;

public class CycleList implements Serializable {

    private Node head;
    private Node tail;
    private int length;

    private ArrayList<Object> arrayList;

    private Comparator comparator;


    private class Node implements Serializable {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            next = prev = null;
        }
    }

    public CycleList(Comparator comparator) {
        int sizeList = 15;
        arrayList = new ArrayList<Object>(sizeList);
        for (int i = 0; i < sizeList; i++)
            arrayList.add(null);
        this.comparator = comparator;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            length++;
            return;
        }
        Node newNode = new Node(data);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
        head.prev = tail;
        length++;
    }

    public void add(Object data, int index) {
        Node tmp = getNode(index);
        Node newNode = new Node(data);
        if (tmp != head) {
            tmp.prev.next = newNode;
            newNode.prev = tmp.prev;
        } else {
            head = newNode;
        }
        newNode.next = tmp;
        tmp.prev = newNode;
        tail.next = head;
        head.prev = tail;
        length++;
    }

    public void remove(int index) {
        Node tmp = getNode(index);
        if (tmp != head) {
            tmp.prev.next = tmp.next;
        } else {
            head = tmp.next;
        }
        if (tmp != tail) {
            tmp.next.prev = tmp.prev;
        } else {
            tail = tmp.prev;
        }
        tmp.next = tmp.prev = null;
        tail.next = head;
        head.prev = tail;
        length--;
    }

    public Object getByIndex(int index) {
        return getNode(index).data;
    }

    public int getLength() {
        return length;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void forEach(Iterator<Object> iterator) {
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            iterator.toDo(tmp.data);
            tmp = tmp.next;
        }
    }

    public void sort(Comparator comparator) {
        if (head != null && head.next != null) {
            tail.next = null;
            head.prev = null;
            head = mergeSort(head, comparator);
            tail = getNode(length - 1);
            tail.next = head;
            head.prev = tail;
        }
    }

    private Node mergeSort(Node headNode, Comparator comparator) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        Node middle = getMidNode(headNode);
        Node middleNext = middle.next;
        middle.next = null;
        Node left = mergeSort(headNode, comparator);
        Node right = mergeSort(middleNext, comparator);
        return merge(left, right, comparator);
    }

    private Node merge(Node firstNode, Node secondNode, Comparator comparator) {
        Node merged = new Node(null);
        Node temp = merged;
        while (firstNode != null && secondNode != null) {
            if (comparator.compare(firstNode.data, secondNode.data) < 0) {
                temp.next = firstNode;
                firstNode.prev = temp;
                firstNode = firstNode.next;
            } else {
                temp.next = secondNode;
                secondNode.prev = temp;
                secondNode = secondNode.next;
            }
            temp = temp.next;
        }
        while (firstNode != null) {
            temp.next = firstNode;
            firstNode.prev = temp;
            firstNode = firstNode.next;
            temp = temp.next;
        }
        while (secondNode != null) {
            temp.next = secondNode;
            secondNode.prev = temp;
            secondNode = secondNode.next;
            temp = temp.next;
            this.tail = temp;
        }
        return merged.next;
    }

    private Node getMidNode(Node node) {
        Node previousNode = node;
        Node currentNode = node;
        while (currentNode.next != null && currentNode.next.next != null) {
            previousNode = previousNode.next;
            currentNode = currentNode.next.next;
        }
        return previousNode;
    }

    public void printList() {
        //String str = null;
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            // str = i + ") " + tmp.data + "\n";
            System.out.print(i + ") ");
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        //return str;
    }

    public String toString() {
        String str = "";
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            str = str + i + ") " + tmp.data + "\n";
            tmp = tmp.next;
        }
        return str;

    }
}
