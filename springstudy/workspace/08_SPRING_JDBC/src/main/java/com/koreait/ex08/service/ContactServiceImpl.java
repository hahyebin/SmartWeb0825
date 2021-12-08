package com.koreait.ex08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex08.domain.Contact;
import com.koreait.ex08.repository.ContactRepository;



public class ContactServiceImpl implements ContactService{
	
	//field
	@Autowired   // @Autowired 가 있으면 의존관계 형성 
	private ContactRepository repository;  // 빈생성 // service는 DB에 접근하는걸 repository에게 위임한다.
	                               // 그렇기 때문에 필요한 메소드에 따라 레파지토리에서 구현한 메소드를 가져와서 호출하는 형식으로 사용한다. 
	
	
	@Override
	public List<Contact> findAllContact() {
		return repository.selectContactList();
	}
	
	@Override
	public void addContact(Contact contact) {
		repository.insertContact(contact);
	}

	
	@Override
	public Contact findContact(Contact contact) {
		return repository.selectContactByNo(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		repository.updateContact(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		repository.deleteContact(contact);
	}
	
	
	
	
	
}
