package com.example.bookshop.serviceimpl;


import com.example.bookshop.entity.Booking;
import com.example.bookshop.pojos.BookingObj;
import com.example.bookshop.mapper.Converter;
import com.example.bookshop.repository.IBookingRepository;
import com.example.bookshop.service.IBookingService;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bookshop.mapper.Converter.converter;


@Service("bookingServiceImpl")
public class BookingServiceImpl implements IBookingService {

    @Autowired(required = true)
    private IBookingRepository bookingRepository;

    @Transactional
    public Booking createBooking(BookingObj bookingObj) {
       return bookingRepository.save(converter.bookingToEntity(bookingObj));
    }

    @Transactional
    public Booking editBooking(BookingObj bookingObj) {
        return bookingRepository.save(converter.bookingToEntity(bookingObj));
    }

    @Transactional
    public Booking getBooking(int idBooking) {
        return bookingRepository.findById(idBooking).get();
    }

    @Transactional
    public void deleteBooking(int idBooking) {
        bookingRepository.deleteById(idBooking);
    }

    @Transactional
    public List<Booking> getAllBookings() {
        return(List<Booking>) bookingRepository.findAll();
    }
}
