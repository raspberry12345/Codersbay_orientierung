package Woche10;

public class LinkedNode<E> {
    private class Node<E> {
        E data;
        Node<E> next;

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("---");
            sb.append(data).append("---");
            return sb.toString();
        }
    }

    private Node<E> head;
    private int index = 0;

    public boolean add(E data) {
        Node node = new Node();
        // next
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;

            }
            n.next = node;
        }
        index++;
        return true;
    }
    // index geht von 0 weg
    public void add(E data, int position) {
        Node node = new Node();
        node.data = data;
        Node safeNode = null;
        if (position == 0) {
            safeNode = head;
            node.next = safeNode;
            head = node;
            index++;
        } else {
            int counter = 0;
            Node runNode = head;
            Node tempNode;
            while (runNode.next != null) {
                if (position - 1 == counter) {
                    tempNode = runNode.next;
                    node.next = tempNode;
                    runNode.next = node;
                    index++;
                }
                runNode = runNode.next;
                counter++;
            }
        }
    }
    public E remove(int position) {
        Node<E> runNode = head;
        E infoNode = null;
        if (position == 0) {
            infoNode = runNode.data;
            runNode = runNode.next;
            head = runNode;
        } else if (0 < position && position < index-1) {
            int counter =0;
            do{
                if (position-1 == counter){
                    infoNode = runNode.next.data;
                    runNode.next = runNode.next.next;
                }
                counter++;
                runNode = runNode.next;
            }while (runNode.next != null);
        } else if (position == index - 1) {
            int counter = 0;
            do {
                if (position-1 == counter){
                    infoNode = runNode.next.data;
                    runNode.next = null;
                }
                counter++;
                if (runNode.next != null){
                    runNode = runNode.next;
                }
            }while(runNode.next != null);
        } else {
            infoNode = null;
        }
        return infoNode;
    }

    public E get(int position) {
        Node<E> node = head;
        Node<E> currentNode = null;
        int counter = 0;
        while (node.next != null) {

            if (counter == position) {
                currentNode = node;
            }
            node = node.next;
            counter++;
        }
        return currentNode.data;
    }

    public int size() {
        return index;
    }
    public void print() {
        Node<E> node = head;
        while (node.next != null) {
            System.out.println(node.toString());
            node = node.next;
        }
        System.out.println(node.toString());
    }

}
