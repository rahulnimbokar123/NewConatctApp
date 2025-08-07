package com.me.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    private String about;
    private String description;
    private boolean favourite=false;
    private String website;
    private String LinkedLink;
   // private List<SocialLink>  socialLinks= new ArrayList<>();
    
   @ManyToOne
   private User user;

   @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch =FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> socialLinks= new ArrayList<>();
 



}
