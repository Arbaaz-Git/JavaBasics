/**
 * 
 */
package JB4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arbaaz Khan
 *	In this program I am creating a produce thread and a consumer thread. The produce thread is producing data to a bounded buffer and the consumer is read said data. The key to the Producer/Consumer problem is to make sure that you don't produce more than the buffer can hold and you don't consume more that the buffer can hold.
 */
class Assignment3 {
	// The buffer class is the bounded buffer from the problem. When called upon it will simply add whatever the produce thread creates and remove what ever the consumer class needs. 
	public static class Buffer {
		private Queue<Integer> bb;
		private int size;
		
		public Buffer(int size) {
			this.size=size;
			this.bb = new LinkedList<>();
		}
		
		public void add(int val) {
			synchronized(this) {
				try {
					while(bb.size()>=size) {
						wait();
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				bb.add(val);
				notify();
			}
		}
		
		public int remove() {
			synchronized(this) {
				try {
					while(bb.size() == 0) {
						wait();
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				int val = bb.poll();
				notify();
				return val;
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {	//Throws exception because we are joining the producer and consumer thread
		Buffer buff = new Buffer(5);	//I am creating a bounded buffer of size 5
		
		//Create the producer thread. Here we are in an infinite loop try to add data to the buffer. 
		Thread producer = new Thread() {
			public void run(){
				try {
					int value =0;
					while(true) {
						buff.add(value);
						System.out.println("Produced: "+value);
						value++;
						
						Thread.sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		//Create the consumer thread. Here we are in an infinite loop removing data from the buffer.
		Thread consumer = new Thread() {
			public void run() {
				try {
					while(true) {
						int value = buff.remove();
						System.out.println("Consumed: "+value);
						Thread.sleep(1000);
					}
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		producer.start();
		consumer.start();
		
		//Join allow for producer and consumer "wait" for the other one to finish what they are doing so it can run
		producer.join();
		consumer.join();

	}

}
