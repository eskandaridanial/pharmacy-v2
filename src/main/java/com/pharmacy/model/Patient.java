package com.pharmacy.model;

import com.pharmacy.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_patient")
public class Patient extends BaseModel {

    @Column(name = "cl_firstname" , nullable = false)
    private String firstName;

    @Column(name = "cl_lastname" , nullable = false)
    private String lastName;

    @Column(name = "cl_gender" , nullable = false)
    private String gender;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_patient")
    private List<Prescription> prescriptions;
}
