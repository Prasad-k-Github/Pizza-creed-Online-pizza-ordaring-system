package com.EAD2.pizzacreed.service.implement;

import com.EAD2.pizzacreed.entity.admin;
import com.EAD2.pizzacreed.repository.adminRepository;
import com.EAD2.pizzacreed.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImplement implements adminService {

    @Autowired
    private adminRepository adminRepository;

    @Override
    public List<admin> getAdmin() {
        return adminRepository.findAll();
    }
}
