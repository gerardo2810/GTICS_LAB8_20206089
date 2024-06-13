package com.example.clase9webservice.entity;

package com.example.entity;

import jakarta.persistence.*;

import javax.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int captureRate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}