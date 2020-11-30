package com.pharmacy.controller;

import com.pharmacy.dto.MedicineDto;
import com.pharmacy.model.Medicine;
import com.pharmacy.service.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;
    private final ModelMapper modelMapper;

    public MedicineController(final MedicineService medicineService , final ModelMapper modelMapper) {
        this.medicineService = medicineService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid Medicine medicine){
        Medicine savedMedicine = medicineService.save(medicine);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMedicine.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/list")
    public List<Medicine> list(){
        return medicineService.findAll();
    }


    @PostMapping("/remove")
    public void remove(@RequestParam Long id){
        medicineService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Medicine find(@PathVariable Long id){
        return medicineService.findById(id);
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id , MedicineDto dto){
        Medicine medicine = medicineService.findById(id);
        modelMapper.map(dto , medicine);
        medicineService.update(medicine);
    }
}
