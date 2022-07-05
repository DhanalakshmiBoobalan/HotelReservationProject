package com.edu.HotelReservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> getReservationList() {
		List<Reservation> reservations = reservationRepository.findAll();
		if(reservations.isEmpty())
			throw new NoRecordFoundException();
		else
			return reservations;
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservationById(long id) {
		Optional<Reservation> reserv = reservationRepository.findById(id);
		if(reserv.isPresent()) {
			return reserv.get();
		}
		else {
			throw new GivenIdNotFoundException();
		}
	}

/*	@Override
	public Reservation updateReservation(long id, Reservation reservation) {
		
		reservations.setNoOfGuest(reservation.getNoOfGuest());
		reservations.setNoOfGuest(reservation.getNoOfGuest());
		reservations.setNoOfGuest(reservation.getNoOfGuest());
		reservations.setNoOfGuest(reservation.getNoOfGuest());
		return null;
	} */

	@Override
	public String deleteReservation(long id) {
		Reservation reservation = new Reservation();
		reservation = reservationRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
		reservationRepository.deleteById(id);
		return "Record id Deleted Sucessfully";
	}

	@Override
	public List<Reservation> getReservationListByDate(LocalDateTime reservationDateTime) {
		
		List<Reservation> reservation = reservationRepository.getReservationListByDate(reservationDateTime);
		if(reservation.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return reservation;
		}
	}

	@Override
	public Reservation updateReservation(long id, Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

}
