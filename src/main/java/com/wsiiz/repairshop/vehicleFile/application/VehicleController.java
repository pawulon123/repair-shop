package com.wsiiz.repairshop.vehicleFile.application;

import com.wsiiz.repairshop.vehicleFile.domain.Owner.Ownership;
import com.wsiiz.repairshop.vehicleFile.domain.Owner.OwnershipRepository;
import com.wsiiz.repairshop.vehicleFile.domain.Vehicle;
import com.wsiiz.repairshop.vehicleFile.domain.VehicleRepository;
import com.wsiiz.repairshop.vehicleFile.domain.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    OwnershipRepository ownershipRepository;

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/vehicle/")
    public ResponseEntity<Vehicle> addNew(
            @RequestBody Vehicle vehicle
    ) {

//    vehicle.getVehiclesOwners().forEach( vehiclesOwners ->   this.assignToOwnership(vehiclesOwners));
//        return vehicleService.save(vehicle);
//        return ResponseEntity.created(null).body(vehicleService.save(vehicle));
        return null;
    }
    private void assignToOwnership(Ownership vehiclesOwners) {
    }

    @GetMapping("/vehicle/{id}")
    public Optional<Vehicle> getOne(@PathVariable("id") Long id) {
        return vehicleRepository.findById(id);
    }

    @GetMapping("/vehicle/")
    public ResponseEntity<List<Vehicle>> getMany(
            @RequestParam(value = "vin", required = false) String vin,
            @RequestParam(value = "register", required = false) String register
//            @RequestParam(value = "surname", required = false) String surname,
//            @RequestParam(value = "insurance", required = false) String insurance
    ) {
        return ResponseEntity.ok(vehicleRepository.findByCriteria(vin, register));
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<ResponseEntity> remove(@PathVariable("id") Long id) {
        return this.deleteById(id);
    }

    private ResponseEntity<ResponseEntity> deleteById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            vehicleRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
