package com.pharmacy.model;

import com.pharmacy.annotation.UniqeMedicineCode;
import com.pharmacy.annotation.UniqeMedicineName;
import com.pharmacy.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_medicine")
public class Medicine extends BaseModel {

    @UniqeMedicineName(message = "Entity Already Exist")
    @Column(name = "cl_name" , nullable = false , unique = true)
    private String name;

    @UniqeMedicineCode(message = "Entity Already Exist")
    @Column(name = "cl_code" , nullable = false , unique = true)
    private Long code;

    @Column(name = "cl_price" , nullable = false)
    private Double price;

    @Column(name = "cl_desc" , nullable = false)
    private String description;
}

