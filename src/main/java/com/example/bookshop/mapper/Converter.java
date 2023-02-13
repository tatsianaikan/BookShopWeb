package com.example.bookshop.mapper;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.entity.Product;
import com.example.bookshop.entity.Status;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.BookingObj;
import com.example.bookshop.pojos.ProductObj;
import com.example.bookshop.pojos.StatusObj;
import com.example.bookshop.pojos.UserObj;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {})
public interface Converter {
    @Autowired
    Converter converter = Mappers.getMapper(Converter.class);

    BookingObj bookingToObj(Booking booking);
    Booking bookingToEntity(BookingObj bookingObj);

    ProductObj productToObj(Product product);
    Product productToEntity(ProductObj productObj);

    UserObj userToObj(User user);
    User userToEntity(UserObj userObj);

    StatusObj statusToObj(Status status);
    Status statusToEntity(StatusObj statusObj);
}
