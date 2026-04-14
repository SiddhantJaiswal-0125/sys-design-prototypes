package DistributedQueue;

public class Consumer implements Runnable{
    DistributedPartionedQueue distributedPartionedQueue;
    Consumer(DistributedPartionedQueue distributedPartionedQueue)
    {
        this.distributedPartionedQueue = distributedPartionedQueue;
    }


    @Override
    public void run()
    {
        while(true) {
            Message m = distributedPartionedQueue.dequeue();
            if(m!=null) {
                processMessage(m);
            }


        }

    }

    void processMessage(Message message)
    {
        try
        {
            System.out.println("Started Processing " +message.getId()+" with Payload "+message.getPayload());
            Thread.sleep(100);
            message.setStatus(Status.ACKED);
            System.out.println("Message is Acknowledged "+message.getId());

        } catch (InterruptedException e) {
            message.setStatus(Status.FAILED);
            throw new RuntimeException(e);
        }
    }


}
