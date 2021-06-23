package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleService implements AbstractService <Vehicle> {
    @Autowired
    VehicleRepository vehicleRepository;
//    Vehicle vehicle;

 public Vehicle add(Vehicle vehicle) {
//        vehicle.getBody().setVehicle(vehicle);
//        vehicle.getChassis().setVehicle(vehicle);
//        vehicle.getVehiclesOwners().forEach(ownership -> ownership.setVehicle(ownership.getVehicle()));
//        vehicle.getVehiclesOwners().forEach(ownership -> ownership.setOwner(ownership.getOwner()));
        return vehicleRepository.save(vehicle);

    }

}
