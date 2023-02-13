package com.example.bookshop.controller;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.entity.Product;
import com.example.bookshop.entity.Status;
import com.example.bookshop.pojos.BookingObj;
import com.example.bookshop.pojos.ProductObj;
import com.example.bookshop.pojos.StatusObj;
import com.example.bookshop.pojos.UserObj;
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
    public Booking createBooking(@RequestParam StatusObj status,
                                 @RequestParam String description,
                                 @RequestParam ProductObj product,
                                 @RequestParam UserObj user){
        return bookingService.createBooking(new BookingObj(status, description, product, user));
    }


    /**
     * Create one new booking in DB
     * @param bookingObj Object
     * @return a JSON with created booking
     */
    @PostMapping("/createBooking")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody BookingObj bookingObj) {
        return bookingService.createBooking(bookingObj);
    }

    /**
     * Edit booking in DB
     * @param bookingobj - Obj
     * @return a JSON with edited Booking
     */
    @PutMapping("/edit")
    @ResponseBody
    public Booking editBooking(@RequestBody BookingObj bookingobj){
        return bookingService.editBooking(bookingobj);
    }

    /**
     * Get Booking by Id
     * @param bookingId - int
     * @return a JSON of found Booking
     */
    @GetMapping("/get")
    @ResponseBody
    public Booking getBooking(@RequestParam int bookingId){
        return bookingService.getBooking(bookingId);
    }

    /**
     * Delete Booking by Id
     * @param bookingId - int
     * @return String message about successful removal of Booking
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteBooking(@RequestParam int bookingId){
        Booking booking = new Booking();
        booking = bookingService.getBooking(bookingId);
        bookingService.deleteBooking(bookingId);
        return booking.getDescription() + " was deleted!";
    }

    /**
     * Receiving all Booking in DB
     * @return a JSON with list of the Booking
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Booking> getAllBooking(){
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
