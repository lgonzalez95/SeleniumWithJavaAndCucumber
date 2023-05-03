package com.lg.utils;

import com.lg.models.BillingDetails;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;

public class ModelMapperUtility {
    private ModelMapper modelMapper = new ModelMapper();

    public BillingDetails mapBillingDetails(List<Map<String, String>> billingDetailsRows) {
        return modelMapper.map(billingDetailsRows.get(0), BillingDetails.class);
    }
}
