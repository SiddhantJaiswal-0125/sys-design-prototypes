package DistributedQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DistributedPartionedQueue {
    private final AtomicInteger count = new AtomicInteger(0);
    List<PartionedQueue> queues = new ArrayList<>();

    DistributedPartionedQueue(int numberOfqueues)
    {
        for(int i = 0;i<numberOfqueues;i++)
            queues.add(new PartionedQueue());
    }

    public void enqueue(String message)
    {
        int idx = count.getAndIncrement() % queues.size();
        queues.get(idx).addMessage(message);
    }

    public Message dequeue()
    {
        for(PartionedQueue pq : queues)
        {
            Message m = pq.pollMessage();
            if(m != null)
            {
                m.setStatus(Status.PROCESSING);
                return m;
            }
        }
        return null;

    }



}
