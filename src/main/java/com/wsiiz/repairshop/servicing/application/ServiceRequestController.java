package com.wsiiz.repairshop.servicing.application;

import com.wsiiz.repairshop.servicing.domain.servicerequest.RequestType;
import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;

import java.util.List;
import java.util.Optional;

import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ServiceRequestController {
    @Autowired
    ServiceRequestService serviceRequestService;

    @GetMapping("/service-requests")
    public ResponseEntity<List<ServiceRequest>> getMany(
            @RequestParam(value = "vehicleId", required = false) Long vehicleId,
            @RequestParam(value = "requestType", required = false) RequestType requestType) {
        return ResponseEntity.ok(serviceRequestService.getMany(vehicleId, requestType));
    }

    @GetMapping("/service-requests/{id}")
    public ResponseEntity<ServiceRequest> getOne(@PathVariable("id") Long id) {
        return serviceRequestService.getOne(id);
    }

    @PostMapping("/service-requests")
    public ResponseEntity<ServiceRequest> addNew(@RequestBody ServiceRequest serviceRequest) {
        return ResponseEntity.created(null).body(serviceRequestService.add(serviceRequest));
    }

    @PutMapping("/service-requests/{id}")
    public ResponseEntity<ServiceRequest> replaceServiceRequest(
            @PathVariable("id") Long id,
            @RequestBody ServiceRequest serviceRequest
    ) {
        return ResponseEntity.created(null).body(serviceRequestService.update(id, serviceRequest));
    }

    @DeleteMapping("/service-requests/{id}")
    public ResponseEntity<ServiceRequest> remove(@PathVariable("id") Long id) {
        return serviceRequestService.remove(id);
    }

}
