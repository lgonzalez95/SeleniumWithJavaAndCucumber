package com.lg.utils;

import com.lg.models.BillingDetails;
import com.lg.models.ElementValidationError;
import com.lg.models.PersonalDetails;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelMapperUtility {
    private ModelMapper modelMapper = new ModelMapper();

    public PersonalDetails mapPersonalDetails(List<Map<String, String>> personalDetailsRows) {
        return modelMapper.map(personalDetailsRows.get(0), PersonalDetails.class);
    }

    public BillingDetails mapBillingOrDeliveryDetails(List<Map<String, String>> billingDetailsRows) {
        BillingDetails billingDetails =  modelMapper.map(billingDetailsRows.get(0), BillingDetails.class);
        billingDetails.setPersonalDetails(mapPersonalDetails(billingDetailsRows));
        return billingDetails;
    }

    public List<ElementValidationError> mapExpectedValidationsForFields(List<Map<String, String>> validationsForFields) {
        return validationsForFields.stream()
                .map(row -> modelMapper.map(row, ElementValidationError.class))
                .collect(Collectors.toList());
    }
}
