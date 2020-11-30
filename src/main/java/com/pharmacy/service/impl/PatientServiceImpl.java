package com.pharmacy.service.impl;

import com.pharmacy.conversion.Conversion;
import com.pharmacy.dto.PatientDetails;
import com.pharmacy.exception.NothingFoundException;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.Patient;
import com.pharmacy.model.Prescription;
import com.pharmacy.repository.PatientRepository;
import com.pharmacy.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final Conversion conversion;

    public PatientServiceImpl(final PatientRepository patientRepository , final Conversion conversion) {
        this.patientRepository = patientRepository;
        this.conversion = conversion;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient customSave(Patient patient, PatientDetails details) {
        patient.setPrescriptions(conversion.popPrescriptions(details));
        return save(patient);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty())
            throw new NothingFoundException("No Patient Found");
        return patients;
    }

    @Override
    public void removeById(Long id) {
        if (id == null)
            throw new NothingFoundException("No Patient Found With ID = " + id);
        else
            patientRepository.deleteById(id);
    }

    @Override
    public Patient findById(Long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty())
            throw new NothingFoundException("No Patient Found With ID = " + id);
        return optional.get();
    }
}
