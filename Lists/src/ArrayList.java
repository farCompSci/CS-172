//Farjad
import java.util.Iterator;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
    private int arraySize;
    private int lengthInput;
    private T[] data;

    public ArrayList() {
        arraySize = 1;
        lengthInput = 0;
        data = (T[]) new Object[arraySize];
    }

    public void add(T item) {
        if (lengthInput == 0){
            data[lengthInput] = item;
        }
        if (lengthInput >= size()){
            resize();
        }
        assert(lengthInput < arraySize);

        data[lengthInput++] = item;
    }

    private void resize() {
        int newCapacity = arraySize * 2;
        T[] newData = (T[])new Object[newCapacity];

        for (int i = 0; i < lengthInput; ++i){
            newData[i] = data[i];
        }

        arraySize = newCapacity;
        data = newData;
    }

    public void clear() {
        arraySize = 1;
        lengthInput = 0;
        data = (T[])new Object[arraySize];
    }

    public boolean contains(T item) {
        for (int i = 0; i < lengthInput; i++) {
            if (item == data[i]) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        return data[index];
    }

    public int indexOf(T item) {
        for (int i = 0; i < lengthInput; i++) {
            if (item == data[i]) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void removeAt(int index) {
        for (int i = 0; i < lengthInput; i++) {
            if (index < i || (index == i && i < lengthInput - 1)){
                data[i] = data[i + 1];
            }
        }
        data[--lengthInput] = null;
        arraySize /= 2;
    }

    public void set(int i, T item) {
        data[i] = item;
    }

    public int size() {
        return lengthInput;
    }

    public String toString() {
        String string = "[";
        StdOut.println(lengthInput);
        for (int i = 0; i < lengthInput; i++) {
            StdOut.println(i);
            string += data[i].toString();

            if (i != lengthInput - 1) {
                string += ", ";
            }
        }

        return string + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> that = (ArrayList<?>)o;
        if (lengthInput != that.lengthInput) return false;
        for (int i = 0; i < lengthInput; i++) {
            if (!Objects.equals(data[i], that.data[i])) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < lengthInput;
        }

        public T next() {
            return data[i++];
        }
    }
}