package CycleList;
//TODO сортировка, не тупая
import Comparator.Comparator;
public class CycleList {

    private Node head;
    private Node tail;
    private int length;

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

    public Object get(int index) {
        return getNode(index).data;
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

    public int size() {
        return length;
    }

    public void forEach(Iterator<Object> iterator) {
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            iterator.toDo(tmp.data);
            tmp = tmp.next;
        }
    }

//    public void sort(Comparator comparator) {
//        head = mergeSort(head, comparator);
//    }
//
//    private Node mergeSort(Node h, Comparator comparator) {
//        if (h == null || h.next == null) {
//            return h;
//        }
//        Node middle = getMiddle(h);
//        Node middleNext = middle.next;
//        middle.next = null;
//        Node left = mergeSort(h, comparator);
//        Node right = mergeSort(middleNext, comparator);
//        return merge(left, right, comparator);
//    }
//
//    private Node merge(Node firstHead, Node secondHead, Comparator comparator) {
//        Node left = firstHead;
//        Node right = secondHead;
//        Node merged = new Node(null);
//        Node temp = merged;
//        while (left != null && right != null) {
//            if (comparator.compare(left.data, right.data) < 0) {
//                temp.next = left;
//                left.prev = temp;
//                left = left.next;
//            } else {
//                temp.next = right;
//                right.prev = temp;
//                right = right.next;
//            }
//            temp = temp.next;
//        }
//        while (left != null) {
//            temp.next = left;
//            left.prev = temp;
//            left = left.next;
//            temp = temp.next;
//        }
//        while (right != null) {
//            temp.next = right;
//            right.prev = temp;
//            right = right.next;
//            temp = temp.next;
//            this.tail = temp;
//        }
//        return merged.next;
//    }
//
//    private Node getMiddle(Node h) {
//        if (h == null)
//            return null;
//        Node fast = h.next;
//        Node slow = h;
//
//        while (fast != tail) {
//            fast = fast.next;
//            if (fast != null) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//        }
//        return slow;
//    }

    private Node getNode(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void printList(){
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(i + ") ");
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    private class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            next = prev = null;
        }
    }
}
