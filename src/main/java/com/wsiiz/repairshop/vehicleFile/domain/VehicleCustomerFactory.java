package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import com.wsiiz.repairshop.shareStore.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleCustomerFactory implements AbstractFactory<Vehicle> {
    @Override
    public VehicleCustomer create() {
        return new VehicleCustomer();
    }
}
