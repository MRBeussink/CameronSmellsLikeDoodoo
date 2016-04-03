/**
 * Created by Mark on 3/18/16.
 */

public interface LinkedList<T>{

    public class Node<T>{
        private Node nextNode;
        private T data;
    }

    boolean add(T anEntry);

    boolean remove();

    int getNumberOfEntries();
}
