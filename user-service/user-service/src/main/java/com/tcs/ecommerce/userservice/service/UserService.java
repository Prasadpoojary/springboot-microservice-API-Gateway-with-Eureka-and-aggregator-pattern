package com.tcs.ecommerce.userservice.service;


import com.tcs.ecommerce.userservice.model.Users;
import com.tcs.ecommerce.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public Users add(Users user)
    {
        return this.userRepository.save(user);
    }

    public void delete(Long id)
    {
        this.userRepository.deleteById(id);
    }

    public List<Users> all()
    {
        return this.userRepository.findAll();
    }

    public Users get(Long id)
    {
        return this.userRepository.findById(id).get();
    }

    public Users update(Long id,Users user)
    {
        if(!this.userRepository.existsById(id))
        {
            return null;
        }
        return this.userRepository.save(user);
    }

}
