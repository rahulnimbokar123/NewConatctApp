package com.me.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String name;
    private String email;
    private String password;
    private String about;
    private String ProfilePic;
    private String phoneNumber;
    private String gender;
    private boolean enabled = false;
    private boolean emailVaried = false;
    private boolean phoneVarified = false;

    // self, fb,google,twitter,linked , github
@Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String provideruserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts= new ArrayList<>();

    
}
