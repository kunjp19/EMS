package com.example.EMS.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeDetails {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    private String firstName;

    private String lastName;

    @OneToMany(targetEntity = Address.class, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Address> addressList;

}
