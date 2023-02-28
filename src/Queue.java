public class Queue {
	public static void main(String[] args) {
		// First demonstrate that the queue can store the entire alphabet

		// Construct new Queue with size 26
		Queue queue_1 = new Queue(26);

		// Generate alphabet
		char[] alphabet = generateAlphabetArray();

		// Enqueue each letter
		for (char c : alphabet) {
			queue_1.enqueue(c);
		}

		// Print size of queue, should be 26
		int size = queue_1.getSize();
		assert (size == 26);
		System.out.println("Current size: " + size);

		// Dequeue all characters except one
		while (size > 1) {
			queue_1.dequeue();
			size--;
		}

		// Get the final character in the queue and print it out
		// Character should be 'z'
		char c = queue_1.dequeue();
		assert (c == 'z');
		System.out.println("Final character: " + c);

		// Demonstrate that dequeueing an empty queue throws a Runtime Exception
		try {
			queue_1.dequeue();
		} catch (RuntimeException e) {
			assert (e.getMessage() == "Queue underflow.");
			System.out.println("Runtime exception as expected. Error message: " + e.getMessage());
		}

		// Demonstrate a queue that can only store 10 characters
		Queue queue_2 = new Queue(10);

		// Tries to add 11 characters to the queue of size 10
		for (int i = 0; i < 11; i++) {
			queue_2.enqueue('a');
		}
		// Should print error message
	}

	private char[] queue;
	private int head;
	private int tail;
	private int size;

	// Initializes the queue with default values
	Queue(int size) {
		queue = new char[size];
		head = 0;
		tail = -1;
		this.size = 0;
	}

	// Adds a character to the queue
	public void enqueue(char c) {
		if (isFull()) {
			System.out.println(
					"Couldn't add character to the queue because the queue is full. Please dequeue before trying to add more characters.");
			return;
		}
		tail++;
		if (tail == this.queue.length) {
			tail = 0;
		}
		this.queue[tail] = c;
		size++;
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Check if the queue is full
	public boolean isFull() {
		return this.size == this.queue.length;
	}

	// Gets a character from the front of the queue
	public char dequeue() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow.");
		}
		char dequeued_char = queue[this.head];
		this.head++;
		if (head == this.queue.length) {
			head = 0;
		}
		this.size--;
		return dequeued_char;
	}

	public int getSize() {
		return this.size;
	}

	public static char[] generateAlphabetArray() {
		return "abcdefghijklmnopqrstuvwxyz".toCharArray();
	}
}
