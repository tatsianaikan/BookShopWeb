package com.example.bookshop.mapper;

import com.example.bookshop.entity.Booking;
import com.example.bookshop.entity.Product;
import com.example.bookshop.entity.Status;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.BookingDto;
import com.example.bookshop.pojosdto.ProductDto;
import com.example.bookshop.pojosdto.StatusDto;
import com.example.bookshop.pojosdto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {})
public interface Converter {
    @Autowired
    Converter converter = Mappers.getMapper(Converter.class);

    BookingDto bookingToDto(Booking booking);
    Booking bookingToEntity(BookingDto bookingDto);

    ProductDto productToDto(Product product);
    Product productToEntity(ProductDto productDto);

    UserDto userToDto(User user);
    User userToEntity(UserDto userDto);

    StatusDto statusToDto(Status status);
    Status statusToEntity(StatusDto statusDto);
}
