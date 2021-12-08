package com.koreait.ex08.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.ex08.domain.Contact;
@Service
public interface ContactService {
	public List<Contact> findAllContact();
	public void addContact(Contact contact);
	public Contact findContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
}
