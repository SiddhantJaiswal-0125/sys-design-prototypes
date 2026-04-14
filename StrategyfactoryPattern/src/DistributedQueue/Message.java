package DistributedQueue;

public class Message {
    private int id;
    private String payload;
    private Status status;
    static  int counter;

    Message( String payload)
    {
        this.id = counter++;
        this.payload = payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getPayload() {
        return payload;
    }

    public Status getStatus() {
        return status;
    }


}
