import java.util.ArrayList;
/**
 * This class represents AbstractDex
 * @author Shaotong Sun
 * @version 12.1.1
 * @param <T> Type
 */
public class AbstractDex<T extends Comparable<? super T>> {
    private ArrayList<T> entries;
    private boolean sorted;
    /**
     * AbstractDex Constructor
     */
    public AbstractDex() {
        entries = new ArrayList<>();
    }
    /**
     * Insertion Sort Method
     */
    public void insertionSort() {
        for (int i = 1; i < entries.size(); i++) {
            T temp = entries.get(i);
            int k;
            for (k = i - 1; k >= 0 && entries.get(k).compareTo(temp) > 0; k--) {
                entries.set(k + 1, entries.get(k));
            }
            entries.set(k + 1, temp);
        }
        sorted = true;
    }
    /**
     * Selection Sort Method
     */
    public void selectionSort() {
        for (int i = 0; i < entries.size() - 1; i++) {
            T min = entries.get(i);
            for (int j = i + 1; j < entries.size(); j++) {
                T temp = entries.get(j);
                if (min.compareTo(temp) > 0) {
                    entries.set(i, temp);
                    entries.set(j, min);
                    min = temp;
                }
            }
        }
        sorted = true;
    }
    /**
     * Binary Search Method
     * @param  element [element]
     * @return         [index of element or -1 if not found]
     */
    public int binarySearch(T element) {
        int first = 0;
        int last = entries.size() - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (entries.get(mid).equals(element)) {
                return mid;
            } else if (entries.get(mid).compareTo(element) < 0) {
                first = mid + 1;
            } else if (entries.get(mid).compareTo(element) > 0) {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;
    }
    /**
     * add element to dex
     * @param newElement [element we want to add]
     */
    public void addToDex(T newElement) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).compareTo(newElement) == 0) {
                return;
            }
        }
        entries.add(newElement);
        sorted = false;
    }
    /**
     * equals method
     * @param  other [another object]
     * @return       [boolean]
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractDex)) {
            return false;
        }
        AbstractDex o = (AbstractDex) other;
        return this.entries.equals(o.entries);
    }
    /**
     * hashCode method
     * @return [int]
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + entries.hashCode();
        return result;
    }
    /**
     * toString method
     * @return [String]
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < entries.size(); i++) {
            str += entries.get(i).toString();
            if (i < entries.size() - 1) {
                str += "\n";
            }
        }
        return str;
    }
    /**
     * getEntries method
     * @return [ArrayList: entries]
     */
    public ArrayList<T> getEntries() {
        return entries;
    }
    /**
     * getSorted method
     * @return [description]
     */
    public boolean getSorted() {
        return sorted;
    }
    /**
     * setEntries method
     * @param entries [new Entry]
     */
    public void setEntries(ArrayList<T> entries) {
        this.entries = entries;
    }
}
