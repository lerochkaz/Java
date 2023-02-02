import java.util.LinkedList;

// Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() -
// помещает элемент в конец очереди, dequeue() - возвращает первый элемент из
// очереди и удаляет его, first() - возвращает первый элемент из очереди, не
// удаляя.

public class MyQueue {
    private LinkedList<Integer> myList;

    MyQueue() {
        myList = new LinkedList<>();
    }

    public void enqueue(int num) {
        myList.addLast(num);
    }

    public int dequeue() {
        int num = myList.getFirst();
        myList.remove(0);
        return num;
    }

    public int first() {
        return myList.getFirst();
    }

}
