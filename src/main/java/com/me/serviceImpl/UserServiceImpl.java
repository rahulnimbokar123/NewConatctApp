package com.me.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.me.Exception.ResourceNotFoundException;
import com.me.Helper.AppConstant;
import com.me.entity.User;
import com.me.repo.UserRepo;
import com.me.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    UserRepo repo;
;    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //userid generated y dynamically
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        //password encode
        //user.setpassword
//user.setProfilePic(userId);
user.setPassword(passwordEncoder.encode(user.getPassword()));
//set role

user.setRolList(List.of(AppConstant.ROLE_USER));
logger.info(userId);
        return repo.save(user);
         
       }

    @Override
    public Optional<User> getUserById(String id) {
        
        return repo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        
      User users= repo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User NOt Found with "));
       users.setName(user.getName());
       users.setEmail(user.getEmail());
       users.setAbout(user.getAbout());
       users.setPassword(user.getPassword());
       users.setPhoneNumber(user.getPhoneNumber());
       users.setProfilePic(user.getProfilePic());
       users.setEnabled(user.isEnabled());
       users.setEmailVaried(user.isEmailVaried());
       users.setPhoneVarified(user.isPhoneVarified());
       users.setProvider(user.getProvider());
       users.setProvideruserId(user.getProvideruserId());

       User savedUser= repo.save(users);
       return Optional.ofNullable(savedUser);
    }

    @Override
    public void deleteUser(String id) {
        
        User users= repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User NOt Found with "));
     repo.delete(users);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user=repo.findById(userId).orElse(null);
        return user != null ? true :false ;
    }
         
    

    @Override
    public boolean isUserExistByEmail(String email) {
         
         User user=repo.findByEmail(email).orElse(null);
          return user != null ? true :false ;
    
    }

    @Override
    public List<User> getAllUsers() {
         
        return repo.findAll();
    }



}
