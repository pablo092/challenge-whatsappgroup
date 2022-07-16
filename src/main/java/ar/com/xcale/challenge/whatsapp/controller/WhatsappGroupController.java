package ar.com.xcale.challenge.whatsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.xcale.challenge.whatsapp.service.WhatsappGroupService;

@Controller
public class WhatsappGroupController {

	@Autowired
	private  WhatsappGroupService service;

	@RequestMapping("/greet")
	public @ResponseBody String greet() {
		return service.greet();
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ResponseEntity<String> sendMessage(@RequestParam("userName") String userName, @RequestParam("message")  String message) {
		service.sendMessage(userName, message);
		return new ResponseEntity("Message sent to group", HttpStatus.CREATED);
	}

}