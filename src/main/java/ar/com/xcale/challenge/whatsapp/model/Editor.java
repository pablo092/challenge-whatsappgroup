package ar.com.xcale.challenge.whatsapp.model;

import java.util.List;

public class Editor {

    public ChatRoom events;

    public Editor(List<User> users) {
        this.events = new ChatRoom("1L", "The group", users);
    }

    public void send(ChatMsg chatMsg) {
        chatMsg.setRoom(events);
        chatMsg.setStatus(Status.Sent);
        System.out.println(chatMsg.getFrom().getPhone()+ " sent " + chatMsg.getMsg());
        events.notify(chatMsg);
    }
}