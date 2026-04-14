package DistributedQueue;

//Main Runner Class
public class DistributedQueueDemo {
    public static void main(String[] args) {
        DistributedPartionedQueue queue = new DistributedPartionedQueue(3);

        Producer producer = new Producer(queue);

        // Start Consumers
        for (int i = 0; i < 2; i++) {
            new Thread(new Consumer(queue)).start();
        }

        // Produce Messages
        for (int i = 0; i < 10; i++) {
            producer.produce(("Message-" + i));
        }
    }

}
