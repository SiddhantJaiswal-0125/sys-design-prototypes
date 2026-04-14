package DistributedQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PartionedQueue {
    Queue<Message> partionedQueue;

    PartionedQueue()
    {
        partionedQueue = new LinkedBlockingQueue<>();
    }

    public void addMessage(String message)
    {
        partionedQueue.offer(new Message(message));
    }

    public Message pollMessage()
    {
        return partionedQueue.poll();
    }
}
