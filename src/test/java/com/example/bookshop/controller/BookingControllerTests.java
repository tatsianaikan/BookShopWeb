package com.example.bookshop.controller;

import com.example.bookshop.pojosdto.*;
import com.example.bookshop.pojosdto.enums.RoleType;
import com.example.bookshop.pojosdto.enums.StatusType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.Random;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class BookingControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    BookingController bookingController;
    @Autowired
    private UserController userController;

    UserDto userDto;
    String actualUserName = "tata2";
    String actualUserlogin = "kolyta2";


    @Test
    public void givenNewBooking_whenGetBooking_thenStatus200() throws Exception {
        StatusDto status = new StatusDto(StatusType.SUBMITTED);
        String bookDescription = "Some description of Booking";
        ProductDto productDto = new ProductDto("Any"+ new Random());
        userDto = addUser();

        BookingDto bookingExp = new BookingDto();
        bookingExp.setDescription(bookDescription);
        bookingExp.setStatus(status);
        bookingExp.setProduct(productDto);
        bookingExp.setUser(userDto);

       bookingController.createBooking(bookingExp);

        mvc.perform(get("/booking/get?bookingId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value(bookDescription))
                .andExpect(jsonPath("$.user.name").value(actualUserName));
    }


    @Test
	public void receiveAllBooks() throws Exception {
        mvc.perform(get("/booking/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    protected UserDto addUser() {
        RoleDto roleType = new RoleDto(RoleType.CUSTOMER);
        userDto = new UserDto(actualUserName, actualUserlogin, roleType);
        userController.addNewUser(userDto);
        return userDto;
    }

}
