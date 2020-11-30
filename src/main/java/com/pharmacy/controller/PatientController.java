package com.pharmacy.controller;

import com.pharmacy.dto.PatientDetails;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.Patient;
import com.pharmacy.service.PatientService;
import com.pharmacy.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    public PatientController(final PatientService patientService , final PrescriptionService prescriptionService) {
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(Patient patient , PatientDetails patientDetails){
        Patient savedPatient = patientService.customSave(patient , patientDetails);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPatient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/list")
    public List<Patient> list(){
        return patientService.findAll();
    }

    @PostMapping("/remove")
    public void remove(@RequestParam Long id){
        patientService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Patient find(@PathVariable Long id){
        return patientService.findById(id);
    }

    @PostMapping("/remove/prescription")
    public void removePrescription(@RequestParam Long id){
        prescriptionService.removeById(id);
    }
}
