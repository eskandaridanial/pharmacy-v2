package com.pharmacy.service.impl;

import com.pharmacy.repository.PrescriptionRepository;
import com.pharmacy.service.PrescriptionService;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(final PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public void removeById(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
