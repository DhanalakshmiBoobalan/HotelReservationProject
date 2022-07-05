package com.edu.HotelReservation.service;

import java.time.LocalDateTime;
import java.util.List;

import com.edu.HotelReservation.entity.Reservation;

public interface ReservationService {

	List<Reservation> getReservationList();

	Reservation saveReservation(Reservation reservation);

	Reservation getReservationById(long id);

	Reservation updateReservation(long id, Reservation reservation);

	String deleteReservation(long id);

	List<Reservation> getReservationListByDate(LocalDateTime reservationDateTime);

}
