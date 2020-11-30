package com.pharmacy.model;

import com.pharmacy.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_prescription")
public class Prescription extends BaseModel {

    @Column(name = "cl_code" , nullable = false)
    private Long code;

    @Column(name = "cl_creation_date" , nullable = false , updatable = false)
    private LocalDate creationDate;

    @Column(name = "cl_visit_date" , nullable = false , updatable = false)
    private LocalDate visitDate;
}
