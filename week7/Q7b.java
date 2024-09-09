package week7;
import java.util.*;
public class Q7b {
    
        public static void main(String[] args) {
            // Test with Integers
            GenericPriorityQueue<Integer> intQueue = new GenericPriorityQueue<>();
            intQueue.add(5);
            intQueue.add(1);
            intQueue.add(3);
            System.out.println("Integer Priority Queue:");
            while (!intQueue.isEmpty()) {
                System.out.println(intQueue.poll());
            }
    
            // Test with Doubles
            GenericPriorityQueue<Double> doubleQueue = new GenericPriorityQueue<>();
            doubleQueue.add(5.5);
            doubleQueue.add(1.1);
            doubleQueue.add(3.3);
            System.out.println("\nDouble Priority Queue:");
            while (!doubleQueue.isEmpty()) {
                System.out.println(doubleQueue.poll());
            }
    
            // Test with Strings
            GenericPriorityQueue<String> stringQueue = new GenericPriorityQueue<>();
            stringQueue.add("apple");
            stringQueue.add("banana");
            stringQueue.add("cherry");
            System.out.println("\nString Priority Queue:");
            while (!stringQueue.isEmpty()) {
                System.out.println(stringQueue.poll());
            }
        }
    
    
}


 class GenericPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> priorityQueue;

    public GenericPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    // Add an element to the priority queue
    public void add(T element) {
        priorityQueue.add(element);
    }

    // Remove and return the highest-priority element
    public T poll() {
        return priorityQueue.poll();
    }

    // Peek at the highest-priority element without removing it
    public T peek() {
        return priorityQueue.peek();
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    // Get the size of the priority queue
    public int size() {
        return priorityQueue.size();
    }

    // Clear the priority queue
    public void clear() {
        priorityQueue.clear();
    }
}
