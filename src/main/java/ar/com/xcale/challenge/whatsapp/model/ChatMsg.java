package ar.com.xcale.challenge.whatsapp.model;

public class ChatMsg {

    private User from;
    private ChatRoom room;
    private String msg;
    private Status status;

    public ChatMsg(User from, String msg) {
        this.from = from;
        this.msg = msg;
        this.status = Status.Delivery;
        System.out.println("Sending message...");
    }

    public User getFrom() {
        return from;
    }
    public void setFrom(User from) {
        this.from = from;
    }
    public ChatRoom getRoom() {
        return room;
    }
    public void setRoom(ChatRoom room) {
        this.room = room;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((msg == null) ? 0 : msg.hashCode());
        result = prime * result + ((room == null) ? 0 : room.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChatMsg other = (ChatMsg) obj;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (msg == null) {
            if (other.msg != null)
                return false;
        } else if (!msg.equals(other.msg))
            return false;
        if (room == null) {
            if (other.room != null)
                return false;
        } else if (!room.equals(other.room))
            return false;
        if (status != other.status)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ChatMsg [from=" + from + ", msg=" + msg + ", room=" + room + ", status=" + status + "]";
    }
}
