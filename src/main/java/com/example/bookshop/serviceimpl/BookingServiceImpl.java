package com.example.bookshop.serviceimpl;


import com.example.bookshop.entity.Booking;
import com.example.bookshop.pojosdto.BookingDto;
import com.example.bookshop.repository.IBookingRepository;
import com.example.bookshop.service.IBookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.example.bookshop.mapper.Converter.converter;


@Service("bookingServiceImpl")
public class BookingServiceImpl implements IBookingService {

    @Autowired(required = true)
    private IBookingRepository bookingRepository;

    @Transactional
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking bookingEntry = bookingRepository.save(converter.bookingToEntity(bookingDto));
        return converter.bookingToDto(bookingEntry);
    }

    @Transactional
    public BookingDto editBooking(BookingDto bookingDto) {
        Booking bookingEntry = bookingRepository.save(converter.bookingToEntity(bookingDto));
        return converter.bookingToDto(bookingEntry);
    }

    @Transactional
    public BookingDto getBooking(int idBooking) {
        Booking bookingEntry = bookingRepository.findById(idBooking).get();
        return converter.bookingToDto(bookingEntry);
    }

    @Transactional
    public String deleteBooking(int idBooking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto = getBooking(idBooking);

        bookingRepository.deleteById(idBooking);
        return "The booking = '" + bookingDto.getDescription() + "' with ID = '" + idBooking + "' was deleted!";
    }

    @Transactional
    public List<BookingDto> getAllBookings() {
        List<Booking> bookingEntryList = (List<Booking>)bookingRepository.findAll();
        return bookingEntryList.stream()
                               .map(bookingEntry -> converter.bookingToDto(bookingEntry))
                               .collect(Collectors.toList());
    }
}
