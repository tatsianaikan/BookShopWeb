package com.example.bookshop.service;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.pojosdto.BookingDto;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface IBookingService {

    public BookingDto createBooking(BookingDto bookingDto);
    public BookingDto editBooking(BookingDto booking);
    public BookingDto getBooking (int idBooking);
    public String deleteBooking (int idBooking);

    public List<BookingDto> getAllBookings();
}
