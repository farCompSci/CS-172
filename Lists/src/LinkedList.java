//Farjad
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    T[] items = (T[])new Object[1];

    private class Node {
         Node next;
         T value;

         public Node(T item){
             this.value = item;
             this.next = null;
         }
    }

    public LinkedList(){
        head = null;
    }

    private Node head;



    public void add(T item) {
        Node node = new Node(item);
        if(head == null){
            head = node;
        }
        else{
            assert head != null;
            Node i = this.head;
            while (i.next != null) {
                i = i.next;
            }
            assert i != null;
            i.next = node;
        }

    }


    public void clear() {
        this.head = null;
    }

    public String toString(){
        String string = "[";
        Node n = head;
        while (n != null){
            string += n.value.toString();
            n = n.next;
            if (n != null) {
                string += ", ";
            }
        }

        return string + "]";
    }

    public boolean contains(T item) {
        Node i = this.head;
        while (i != null) {
            if(item == i.value){
                return true;
            }
            i = i.next;
        }

        return false;
    }


    public T get(int i) {
        int start = 0;
        Node j = this.head;
        while (start < i) {
            j = j.next;
            start++;
        }
        return j.value;
    }


    public int indexOf(T item) {
        int start = 0;
        Node j = this.head;
        while (j != null) {
            if (j.value == item){
                return start;
            }
            j = j.next;
            start++;
        }

        return -1;
    }


    public void removeAt(int i) {
        int j = 0;
        Node n = this.head;

        if(i == 0){
            this.head = n.next;
            return;
        }
        Node previous = null;
        while(j<i){
            previous = n;
            n = n.next;
            j++;
        }
        previous.next = n.next;
        return;
    }


    public void set(int i, T item) {
        int start = 0;
        Node j = this.head;
        while (j != null) {
            if (start == i){
                j.value = item;
            }
            j = j.next;
            start++;
        }


    }


    public int size() {
        Node node = head;
        int count = 0;

        while (node != null){
            node = node.next;
            count++;
        }

        return count;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T> {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.value;
            current = current.next;
            return item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList that = (LinkedList)o;
        Node thisNode = this.head;
        Node thatNode = that.head;
        while (thisNode != null && thatNode != null) {
            if (!thisNode.value.equals(thatNode.value)) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        if (thisNode == thatNode) return true;
        else                      return false;
    }
}
