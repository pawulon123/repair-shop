package com.wsiiz.repairshop.servicing.application;

import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.service.ServiceRepository;
import com.wsiiz.repairshop.servicing.domain.service.ServiceService;

import java.util.List;
import java.util.Optional;

import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("/services")
    public ResponseEntity<List<Service>> getMany(
            @RequestParam(value = "description", required = false) String description) {
        return ResponseEntity.ok(serviceService.getMany(description));
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Service> getOne(@PathVariable("id") Long id) {
        return serviceService.getOne(id);
    }

    @PostMapping("/services")
    public ResponseEntity<Service> addNew(@RequestBody Service service) {
        return ResponseEntity.created(null).body(serviceService.add(service));
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<Service> remove(@PathVariable("id") Long id) {
        return serviceService.remove(id);
    }

}
