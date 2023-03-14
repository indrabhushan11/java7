package com.kishan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("MessageService")
public class MessageService {

	@Autowired
	MessageRepository ar;

	public void Save(int mid, String message) {
		Message m = new Message();
		m.setMid(mid);
		m.setMessage(message);
		ar.save(m);
	}
	public void Delete(int mid) {
		Message m = new Message();
		m.setMid(mid);
		
		ar.delete(m);
	
	}
	public void Update(int mid, String message) {
		Message m = new Message();
		m.setMid(mid);
		m.setMessage(message);
		ar.save(m);
	
	}
	

	public List<Message> getMessages() {
		List<Message> al = (List<Message>) ar.findAll();
		return al;
	}
}
