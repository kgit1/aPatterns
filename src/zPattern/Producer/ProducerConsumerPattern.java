package zPattern.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//Producer consumer pattern is every where in real life and depict coordination 
//and collaboration. Like one person is preparing food (Producer) while other 
//one is serving food (Consumer), both will use shared table for putting food 
//plates and taking food plates. Producer which is the person preparing food 
//will wait if table is full and Consumer (Person who is serving food) will 
//wait if table is empty. table is a shared object here. On Java library 
//Executor framework itself implement Producer Consumer design pattern be 
//separating responsibility of addition and execution of task.

//Benefit of Producer Consumer Pattern
//Its indeed a useful design pattern and used most commonly while writing 
//multi-threaded or concurrent code.here is few of its benefit:
//1)Producer Consumer Pattern simple development.you can Code Producer 
//and Consumer independently and Concurrently,they just need to know 
//shared object.
//2)Producer doesn'tneed to know about who is consumer or how many consumers 
//are there.Same is true with Consumer.
//3)Producer and Consumer can work with different speed.There is no risk of 
//Consumer consuming half-baked item.In fact by monitoring consumer speed one 
//can introduce more consumer for better utilization.
//4)Separating producer and Consumer functionality result in more clean,
//readable and manageable code.
//Producer Consumer Problem in Multi-threading
//Producer-Consumer Problem is also a popular java interview question where 
//interviewer ask to implement producer consumer design pattern so that 
//Producer should wait if Queue or bucket is full and Consumer should wait 
//if queue or bucket is empty.This problem can be implemented or solved by 
//different ways in Java,classical way is using wait and notify method to 
//communicate between Producer and Consumer thread and blocking each of them on 
//individual condition like full queue and empty queue.With introduction of 
//BlockingQueue Data Structure in Java 5 Its now much simpler because 
//BlockingQueue provides this control implicitly by introducing blocking 
//methods put()and take().Now you don'trequire to use wait and notify to 
//communicate between Producer and Consumer.BlockingQueue put()method will 
//block if Queue is full in case of Bounded Queue and take()will block if 
//Queue is empty.In next section we will see a code example of Producer 
//Consumer design pattern.

public class ProducerConsumerPattern {

	public static void main(String args[]) {

		// Creating shared object
		BlockingQueue sharedQueue = new LinkedBlockingQueue();

		// Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producer(sharedQueue));
		Thread consThread = new Thread(new Consumer(sharedQueue));

		// Starting producer and Consumer thread
		prodThread.start();
		consThread.start();
	}

}

// Producer Class in java
class Producer implements Runnable {

	private final BlockingQueue sharedQueue;

	public Producer(BlockingQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Produced: " + i);
				sharedQueue.put(i);
			} catch (InterruptedException ex) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

}

// Consumer Class in Java
class Consumer implements Runnable {

	private final BlockingQueue sharedQueue;

	public Consumer(BlockingQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + sharedQueue.take());
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

}

// Output:
// Produced: 0
// Produced: 1
// Consumed: 0
// Produced: 2
// Consumed: 1
// Produced: 3
// Consumed: 2
// Produced: 4
// Consumed: 3
// Produced: 5
// Consumed: 4
// Produced: 6
// Consumed: 5
// Produced: 7
// Consumed: 6
// Produced: 8
// Consumed: 7
// Produced: 9
// Consumed: 8
// Consumed: 9
