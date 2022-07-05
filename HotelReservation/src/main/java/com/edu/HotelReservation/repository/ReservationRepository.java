package com.edu.HotelReservation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.HotelReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> getReservationListByDate(LocalDateTime reservationDateTime);

}
