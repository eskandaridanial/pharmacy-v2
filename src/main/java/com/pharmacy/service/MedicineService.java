package com.pharmacy.service;

import com.pharmacy.model.Medicine;

import java.util.List;

public interface MedicineService {

    Medicine save(Medicine medicine);

    List<Medicine> findAll();

    void removeById(Long id);

    Medicine findById(Long id);

    void update(Medicine medicine);
}
