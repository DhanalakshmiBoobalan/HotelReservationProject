package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<Room> getRoomList() {
		List<Room> rooms = roomRepository.findAll();
		if(rooms.isEmpty()) {
			throw new NoRecordFoundException();
		}
		else {
			return rooms;
		}
	}

	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(long id) {
		Optional<Room> room = roomRepository.findById(id);
		if(room.isPresent()) {
			return room.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	}

/*	@Override
	public Room updateRoom(long id, Room room) {
		
		//user.setFirstName(user.getFirstName());
		
		room.setNoOfBed(room.getNoOfBed());
		room.setRoomFare(room.getRoomFare());
		room.setStatus(room.getStatus());
		room.setNoOfBed(room.getNoOfBed());
		
		
		ResourceNotFoundException("Room", "")
		return rooms;
	} */

	@Override
	public String deleteRoom(long id) {
		Room room = new Room();
		room = roomRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
		roomRepository.deleteById(id);
		return "Record is Deleted Sucessfully";
	}

@Override
public Room updateRoom(long id, Room room) {
	// TODO Auto-generated method stub
	return null;
}


}
