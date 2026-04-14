package DistributedQueue;

public class Producer {
    DistributedPartionedQueue distributedPartionedQueue;

    Producer(DistributedPartionedQueue distributedPartionedQueue)
    {
        this.distributedPartionedQueue = distributedPartionedQueue;
    }

    public void produce(String payload)
    {
        distributedPartionedQueue.enqueue(payload);
    }

}
