package com.example.bookshop.service;

import com.example.bookshop.controller.*;
import com.example.bookshop.pojosdto.*;
import com.example.bookshop.pojosdto.enums.RoleType;
import com.example.bookshop.pojosdto.enums.StatusType;
import com.example.bookshop.serviceimpl.BookingServiceImpl;
import com.example.bookshop.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest()
class BookingServiceTests {
    @Autowired
    private BookingServiceImpl bookingService;
    @Autowired
    private UserServiceImpl userService;

    UserDto userDto;


    @Test
    public void addNewBookTest() {
        String bookingDescription = "Some description of Booking";

        BookingDto bookingExp = new BookingDto();
        bookingExp.setStatus(new StatusDto(StatusType.SUBMITTED));
        bookingExp.setDescription(bookingDescription);
        bookingExp.setProduct(new ProductDto("Any"+ new Random()));
        bookingExp.setUser(addUser());

        bookingExp = bookingService.createBooking(bookingExp);
        assertThat(bookingExp.getStatus().equals(StatusType.SUBMITTED));
        assertThat(bookingExp.getDescription().equals(bookingDescription));
        assertThatNoException();

    }

    @Test
    @AfterTestMethod("addNewBooks")
	public void givenAllBooks() {
        ArrayList<BookingDto> books = new ArrayList<>();
        books = (ArrayList<BookingDto>) bookingService.getAllBookings();
        assertThat(books.size() > 0);
    }


    protected UserDto addUser() {
        String actualUserName = "tata2";
        String actualUserlogin = "kolyta2";
        RoleDto roleType = new RoleDto(RoleType.CUSTOMER);
        userDto = new UserDto(actualUserName, actualUserlogin, roleType);
        userService.addNewUser(userDto);
        return userDto;
    }

}
