package com.pharmacy.annotation.validator;

import com.pharmacy.annotation.UniqeMedicineName;
import com.pharmacy.repository.MedicineRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqeMedicineNameValidator implements ConstraintValidator<UniqeMedicineName, String> {

    private final MedicineRepository medicineRepository;

    public UniqeMedicineNameValidator(final MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public void initialize(UniqeMedicineName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if (medicineRepository == null)
            return true;
        return medicineRepository.findByName(name).isEmpty();
    }
}
