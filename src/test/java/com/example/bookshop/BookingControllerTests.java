package com.example.bookshop;

import com.example.bookshop.controller.*;
import com.example.bookshop.entity.Booking;
import com.example.bookshop.entity.Status;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.ProductObj;
import com.example.bookshop.pojos.RoleObj;
import com.example.bookshop.pojos.StatusObj;
import com.example.bookshop.pojos.UserObj;
import com.example.bookshop.pojos.enums.RoleType;
import com.example.bookshop.pojos.enums.StatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest()
class BookingControllerTests {
    @Autowired
    private BookingController bookingController;
    @Autowired
    private UserController userController;

    UserObj userObj;


    @Test
    public void addNewBooksObj_Status200() {
        StatusObj status = new StatusObj(StatusType.SUBMITTED);
        String bookDescription = "Some description of Booking";
        ProductObj productObj = new ProductObj("Any"+ new Random());
        userObj = addUser();

        Booking bookingExp = new Booking();
        bookingExp = bookingController.createBooking(status, bookDescription, productObj, userObj);
        assertThat(bookingExp.getStatus().equals(StatusType.SUBMITTED));
        assertThat(bookingExp.getDescription().equals(bookDescription));
        assertThatNoException();

    }

    @Test
    @AfterTestMethod("addNewBooksObj_Status200")
	public void givenAllBooks_Status200() {
        ArrayList<Booking> books = new ArrayList<>();
        books = (ArrayList<Booking>) bookingController.getAllBooking();
        assertThat(books.size() > 0);

    }


    protected UserObj addUser() {
        String actualUserName = "tata2";
        String actualUserlogin = "kolyta2";
        RoleObj roleType = new RoleObj(RoleType.CUSTOMER);
        userObj = new UserObj(actualUserName, actualUserlogin, roleType);
        userController.addNewUser(userObj);
        return userObj;
    }

}
