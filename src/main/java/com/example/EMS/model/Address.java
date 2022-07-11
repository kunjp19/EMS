package com.example.EMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    private  String addressType;
    private String streetName;

    private String city;

    private String state;

    private int zipCode;

    @ManyToOne
    @JoinColumn(name="emp_id")
    @JsonIgnore
    private EmployeeDetails employeeDetails;
}
