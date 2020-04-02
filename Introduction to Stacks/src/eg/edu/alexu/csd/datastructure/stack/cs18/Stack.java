package eg.edu.alexu.csd.datastructure.stack.cs18;

public class Stack implements IStack {

    private static class Node {
        Object element;
        Node next;
        Node (Object object) {
            this.element = object;
        }
    }
    private Node top;
    private int size;
    Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public Object pop() {
        Object temp;
        if (isEmpty()) {
            throw new RuntimeException ("Stack is empty.");
        }else {
            temp = top.element;
            top = top.next;
            size--;
        }
        return temp;
    }

    @Override
    public Object peek() {
        Object temp;
        if (isEmpty()) {
            throw new RuntimeException ("Stack is empty.");
        }else {
            temp = top.element;
        }
        return temp;
    }

    @Override
    public void push(Object element) {
        Node node = new Node(element);
        node.next = top;
        top = node;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}