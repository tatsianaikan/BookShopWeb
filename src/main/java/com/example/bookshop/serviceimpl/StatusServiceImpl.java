package com.example.bookshop.serviceimpl;

import com.example.bookshop.entity.Status;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.StatusObj;
import com.example.bookshop.pojos.UserObj;
import com.example.bookshop.pojos.enums.StatusType;
import com.example.bookshop.repository.IStatusRepository;
import com.example.bookshop.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.bookshop.mapper.Converter.converter;

@Service
public class StatusServiceImpl {
    @Autowired
    private IStatusRepository statusRepository;

    @Transactional
    public void fillStatuses() {
        List<Status> statusList = new ArrayList<>();
        for (StatusType type : StatusType.values()){
            statusList.add(converter.statusToEntity(new StatusObj(type)));
        }
        statusRepository.saveAll(statusList);
    }
}
