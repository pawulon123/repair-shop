package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import com.wsiiz.repairshop.shareStore.VehicleAbstract;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory implements AbstractFactory<Vehicle> {
    @Override
    public Vehicle create() {
        return new Vehicle();
    }
}
