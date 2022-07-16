package ar.com.xcale.challenge.whatsapp.service;

import org.springframework.stereotype.Service;

import ar.com.xcale.challenge.whatsapp.model.ChatMsg;
import ar.com.xcale.challenge.whatsapp.model.Editor;
import ar.com.xcale.challenge.whatsapp.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class WhatsappGroupService {

    private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	private List<User> users = Arrays.asList(new User(counter.incrementAndGet(), "Pablo", "pablo@gmail.com", "123456789"),
	new User(counter.incrementAndGet() , "Pedro", "pedro@gmail.com", "321654987"),
	new User(counter.incrementAndGet() , "Jose", "jose@gmail.com", "654987321"),
	new User(counter.incrementAndGet() , "Juan", "juan@gmail.com", "789456123"));

	private Editor editor = new Editor(users);

    public String greet() {
		return String.format(template, "World");
	}

	public void sendMessage(String userName, String message) {
		Optional<User> optional = users.stream().filter(u -> u.getName().equals(userName)).findFirst();
		if (optional.isPresent()) {
			ChatMsg chatMsg = new ChatMsg(optional.get(), message);
			editor.send(chatMsg);
		} else {
			throw new RuntimeException("User not found in the group!");
		}
	}
}
