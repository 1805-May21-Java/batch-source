package com.revature.threads;

public class ProducerConsumer {


	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		Thread producerWorker = new Thread(producerJob,"PRODUCER");
		Thread consumerWorker = new Thread(consumerJob,"CONSUMER");
		producerWorker.start();
		consumerWorker.start();
	}

}

class Basket {

	private int contents;
	private boolean available = false;

	public synchronized int get() {

		// while nothing is available to be consumed, we want to wait for something to become available
		while (!available) {
			try {
				System.out.println("\t\t\t" + Thread.currentThread().getName() + " is waiting");
				wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// when something is available, we get that resource and we indicate that nothing is available
		available = false;
		notify();
		return contents;

	}

	public synchronized void put(int value) {

		while (available) {
			try {
				System.out.println("\t\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();  
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notify();

	}

}

class Producer implements Runnable {

	private Basket basket;

	public Producer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			basket.put(i);
			System.out.println(Thread.currentThread().getName() + " put: " + i);
			try {
				Thread.sleep((int) (Math.random() * 1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {

	private Basket basket;

	public Consumer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got: " + value);
			try {
				Thread.sleep((int) (Math.random() * 1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
