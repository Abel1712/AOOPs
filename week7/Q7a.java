package week7;

import java.util.*;
public class Q7a{
    public static void main(String[] args) {
        // Test LinkedListStack with Integer
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("LinkedListStack Integer:");
        System.out.println("Peek: " + linkedListStack.peek());
        System.out.println("Pop: " + linkedListStack.pop());
        System.out.println("Is empty: " + linkedListStack.isEmpty());

        // Test ArrayStack with String
        Stack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("Apple");
        arrayStack.push("Banana");
        arrayStack.push("Cherry");
        System.out.println("\nArrayStack String:");
        System.out.println("Peek: " + arrayStack.peek());
        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Is empty: " + arrayStack.isEmpty());

        // Test ArrayStack with Character
        Stack<Character> charArrayStack = new ArrayStack<>();
        charArrayStack.push('A');
        charArrayStack.push('B');
        charArrayStack.push('C');
        System.out.println("\nArrayStack Character:");
        System.out.println("Peek: " + charArrayStack.peek());
        System.out.println("Pop: " + charArrayStack.pop());
        System.out.println("Is empty: " + charArrayStack.isEmpty());
    }
}
 interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
}


 class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void push(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        T element = (T) array[--size];
        array[size] = null; // Clear reference to help GC
        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}

