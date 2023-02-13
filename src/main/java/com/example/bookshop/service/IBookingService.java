package com.example.bookshop.service;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.entity.User;
import com.example.bookshop.mapper.Converter;
import com.example.bookshop.pojos.BookingObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface IBookingService {

    public Booking createBooking(BookingObj bookingObj);
    public Booking editBooking(BookingObj booking);
    public Booking getBooking (int idBooking);
    public void deleteBooking (int idBooking);

    public List<Booking> getAllBookings();
}
