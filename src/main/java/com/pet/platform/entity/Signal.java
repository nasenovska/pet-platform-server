package com.pet.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "signal")
@Scope("session")
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    @Size(min = 4, max = 500)
    @NonNull
    private String description;

    @Column(name = "animal_description")
    @Size(min = 4, max = 500)
    private String animalDescription;

    @Column(name = "location")
    @NonNull
    private String location;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Please, insert a valid phone number.")
    private String phoneNumber;
}
