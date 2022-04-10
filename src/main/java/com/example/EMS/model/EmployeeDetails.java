package com.example.EMS.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeDetails {
    @Id
    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Column(name = "fa_na")
    public String firstName;

    @Column(name = "la_na")
    public String lastName;

    @Column(name = "st_na")
    public String streetName;

    public String city;

    public String state;

    @Column(name = "zip_cd")
    public int zipCode;
}
