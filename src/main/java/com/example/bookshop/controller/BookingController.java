package com.example.bookshop.controller;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.pojosdto.BookingDto;
import com.example.bookshop.pojosdto.ProductDto;
import com.example.bookshop.pojosdto.StatusDto;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private IBookingService bookingService;


    /**
     * Create new booking in DB
     * @param status of booking
     * @param description - String
     * @return a JSON with created booking
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createBooking(@RequestParam StatusDto status,
                                 @RequestParam String description,
                                 @RequestParam ProductDto product,
                                 @RequestParam UserDto user){
        return bookingService.createBooking(new BookingDto(status, description, product, user));
    }


    /**
     * Create one new booking in DB
     * @param bookingDto Object
     * @return a JSON with created booking
     */
    @PostMapping("/createBooking")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    /**
     * Edit booking in DB
     * @param bookingDto - Obj
     * @return a JSON with edited Booking
     */
    @PutMapping("/edit")
    @ResponseBody
    public BookingDto editBooking(@RequestBody BookingDto bookingDto){
        return bookingService.editBooking(bookingDto);
    }

    /**
     * Get Booking by Id
     * @param bookingId - int
     * @return a JSON of found Booking
     */
    @GetMapping("/get")
    @ResponseBody
    public BookingDto getBooking(@RequestParam int bookingId){
        return bookingService.getBooking(bookingId);
    }

    /**
     * Delete Booking by Id
     * @param bookingId - int
     * @return String message about successful removal of Booking
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteBooking(@RequestParam int bookingId){
        BookingDto bookingDto = new BookingDto();
        bookingDto = bookingService.getBooking(bookingId);
        bookingService.deleteBooking(bookingId);
    }

    /**
     * Receiving all Booking in DB
     * @return a JSON with list of the Booking
     */
    @GetMapping("/all")
    @ResponseBody
    public List<BookingDto> getAllBooking(){
        return bookingService.getAllBookings();
    }

}


/**
 * customer can:
 *      - create booking requests
 *      - edit own booking requests
 *      - cancel booking requests
 *      - view status of booking request
 *
 * managers can:
 *      - create booking requests
 *      - see booking requests
 *      - approve booking request
 *      - reject booking request
 *      - edit own booking requests
 *      - view status of booking request
 *      - delete booking requests
 */
