package com.pharmacy.service;

import com.pharmacy.dto.PatientDetails;
import com.pharmacy.model.Patient;

import java.util.List;

public interface PatientService {

    Patient save(Patient patient);

    Patient customSave(Patient patient , PatientDetails details);

    List<Patient> findAll();

    void removeById(Long id);

    Patient findById(Long id);
}
