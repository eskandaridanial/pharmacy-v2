package com.pharmacy.annotation.validator;

import com.pharmacy.annotation.UniqeMedicineCode;
import com.pharmacy.repository.MedicineRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqeMedicineCodeValidator implements ConstraintValidator<UniqeMedicineCode, Long> {

    private final MedicineRepository medicineRepository;

    public UniqeMedicineCodeValidator(final MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public void initialize(UniqeMedicineCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long code, ConstraintValidatorContext constraintValidatorContext) {
        if (medicineRepository == null)
            return true;
        return medicineRepository.findByCode(code).isEmpty();
    }
}
