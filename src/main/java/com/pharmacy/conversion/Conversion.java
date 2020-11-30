package com.pharmacy.conversion;

import com.pharmacy.dto.PatientDetails;
import com.pharmacy.model.Prescription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conversion {

    private List<LocalDate> popDates(String stringifyDate){
        List<LocalDate> dates = new ArrayList<>();
        stringifyDate = stringifyDate.substring(1 , stringifyDate.length() - 1);
        String[] splited = stringifyDate.split(",");
        for (String string : splited){
            string = string.substring(1 , string.length() - 1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate localDate = LocalDate.parse(string, formatter);
            dates.add(localDate);
        }
        return dates;
    }

    private List<Long> popCodes(String stringifyCode){
        List<Long> codes = new ArrayList<>();
        stringifyCode = stringifyCode.substring(1 , stringifyCode.length() - 1);
        String[] splited = stringifyCode.split(",");
        for (String string : splited){
            string = string.substring(1 , string.length() - 1);
            Long aLong = Long.valueOf(string);
            codes.add(aLong);
        }
        return codes;
    }

    public List<Prescription> popPrescriptions(PatientDetails details){
        List<Prescription> prescriptions = new ArrayList<>();
        List<Long> codes = popCodes(details.getCode());
        List<LocalDate> creationDates = popDates(details.getCreationDate());
        List<LocalDate> visitDate = popDates(details.getVisitDate());

        for (int i = 0 ; i < codes.size() ; i++){
            Prescription prescription = new Prescription();
            prescription.setCode(codes.get(i));
            prescription.setCreationDate(creationDates.get(i));
            prescription.setVisitDate(visitDate.get(i));
            prescriptions.add(prescription);
        }
        return prescriptions;
    }
}
