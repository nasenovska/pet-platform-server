package com.pet.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "grantor")
@Scope("session")
public class Grantor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Please, insert a valid phone number.")
    private String phoneNumber;
}
