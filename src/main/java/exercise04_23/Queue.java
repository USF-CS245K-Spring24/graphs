package exercise04_23;

public interface Queue {
	void enqueue(Object elem);
	Object dequeue();
	boolean empty();
}