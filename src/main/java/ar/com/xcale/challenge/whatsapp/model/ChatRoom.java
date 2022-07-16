package ar.com.xcale.challenge.whatsapp.model;

import java.util.Collection;

public class ChatRoom {

    private String id;
    private String name;
    private Collection<User> users;

    public ChatRoom(String id, String name, Collection<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public void notify(ChatMsg chatMsg) {
        for (EventListener listener : users) {
            if (!listener.equals(chatMsg.getFrom())) {
                listener.update(chatMsg);
            }
        }
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Collection<User> getUsers() {
        return users;
    }
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((users == null) ? 0 : users.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
            ChatRoom other = (ChatRoom) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (users == null) {
            if (other.users != null)
                return false;
        } else if (!users.equals(other.users))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ChatRoom [id=" + id + ", users=" + users + ", name=" + name + "]";
    }

}
