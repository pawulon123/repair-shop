package com.wsiiz.repairshop.vehicleFile.application;

import com.wsiiz.repairshop.shareStore.Vehicle;
import com.wsiiz.repairshop.vehicleFile.domain.VehicleCustomer;
import com.wsiiz.repairshop.vehicleFile.domain.VehicleCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleCustomerController {

    @Autowired
    VehicleCustomerRepository vehicleCustomerRepository;

    @PostMapping("/vehicle-customer/")
    public ResponseEntity<VehicleCustomer> addNew(
            @RequestBody VehicleCustomer vehicle
    ) {
        return ResponseEntity.created(null).body(vehicleCustomerRepository.save(vehicle));
    }

    @GetMapping("/vehicle-customer/{id}")
    public Optional<VehicleCustomer> getOne(@PathVariable("id") Long id) {
        return vehicleCustomerRepository.findById(id);
    }

    @GetMapping("/vehicle-customer/")
    public ResponseEntity<List<VehicleCustomer>> getMany(
            @RequestParam(value = "vin", required = false) String vin,
            @RequestParam(value = "register", required = false) String register
//            @RequestParam(value = "surname", required = false) String surname,
//            @RequestParam(value = "insurance", required = false) String insurance
    ) {
        return ResponseEntity.ok(vehicleCustomerRepository.findByCriteria(vin, register));
    }

    @DeleteMapping("/vehicle-customer/{id}")
    public ResponseEntity<ResponseEntity> remove(@PathVariable("id") Long id) {
        return this.deleteById(id);
    }

    private ResponseEntity<ResponseEntity> deleteById(Long id) {
        Optional<VehicleCustomer> vehicle = vehicleCustomerRepository.findById(id);
        if (vehicle.isPresent()) {
            vehicleCustomerRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
