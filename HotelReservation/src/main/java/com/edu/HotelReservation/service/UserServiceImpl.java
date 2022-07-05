package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
/*	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	} */

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUserList() {
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
			throw new NoRecordFoundException();
		else
			return users;
	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	}

/*	@Override
	public User updateUser(long id, User user) {
		Optional<User> user = userRepository.updateUser();
		
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setContactNo(user.getContactNo());
		user.setAadharNo(user.getAadharNo());
		user.setUserName(user.getUserName());
		user.setPassword(user.getPassword());
		user.setFirstName(user.getFirstName());
		user.setEmailID(user.getEmailId());
		user.setFullAddress(user.getFullAddress());
		
		userRepository.save(user);
		return user;
	} */

	@Override
	public String deleteUser(long id) {
		User user = new User();
		user = userRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
		userRepository.deleteById(id);
		return "Record is Deleted Sucessfully";
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.getUserByFirstName(firstName);
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		return userRepository.getUserByLastName(lastName);
	}

	@Override
	public List<User> getUserByFullName(String firstName, String lastName) {
		return userRepository.getUserByFullName(firstName, lastName);
	}

	@Override
	public User updateUser(long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public User getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	} */


}
