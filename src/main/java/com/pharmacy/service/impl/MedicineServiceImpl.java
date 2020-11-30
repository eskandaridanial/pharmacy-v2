package com.pharmacy.service.impl;

import com.pharmacy.exception.NothingFoundException;
import com.pharmacy.model.Medicine;
import com.pharmacy.repository.MedicineRepository;
import com.pharmacy.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(final MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> findAll() {
        List<Medicine> medicines = medicineRepository.findAll();
        if (medicines.isEmpty())
            throw new NothingFoundException("No Medicine Found");
        return medicines;
    }

    @Override
    public void removeById(Long id) {
        if (id == null)
            throw new NothingFoundException("No Medicine Found With ID = " + id);
        else
            medicineRepository.deleteById(id);
    }

    @Override
    public Medicine findById(Long id) {
        Optional<Medicine> optional = medicineRepository.findById(id);
        if (optional.isEmpty())
            throw new NothingFoundException("No Medicine Found With ID = " + id);
        return optional.get();
    }

    @Override
    public void update(Medicine medicine) {
        medicineRepository.save(medicine);
    }
}
