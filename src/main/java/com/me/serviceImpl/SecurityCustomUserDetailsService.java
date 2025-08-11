package com.me.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.repo.UserRepo;

@Service
public class SecurityCustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found with wmail:"+username));
         

}
}