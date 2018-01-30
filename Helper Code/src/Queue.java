import java.util.NoSuchElementException;

public class Queue<E> {

    private class Node<E> {

        E data;
        Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    private int length = 0;

    public boolean offer(E item){
        if (head == null){
            head = new Node<>(item,tail);
        }
        else if (tail == null){
            tail = new Node<>(item,head);
            head.next = tail;
        }
        else{
            Node prevTail = tail;
            tail = new Node<>(item,head);
            prevTail.next = tail;
        }
        size++;
        length++;
        return true;
    }

    public E remove(){
        if (size == 1){
            E data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        else if (head != null){
            E data = head.data;
            head = head.next;
            tail.next = head;
            size--;
            return data;
        }

        throw new NoSuchElementException();
    }

    public E peek(){
        if (head != null){
            return head.data;
        }
        return null;
    }

    public E poll(){
        if (size == 1){
            E data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        else if (head != null){
            E data = head.data;
            head = head.next;
            tail.next = head;
            size--;
            return data;
        }
        return null;
    }

    public E element(){
        if (head != null){
            return head.data;
        }
        throw new NoSuchElementException();
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int length(){
        return length;
    }

    public int size(){
        return size;
    }

}
