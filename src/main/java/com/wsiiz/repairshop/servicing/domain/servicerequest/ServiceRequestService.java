package com.wsiiz.repairshop.servicing.domain.servicerequest;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ServiceRequestService implements AbstractService<ServiceRequest> {

    @Autowired
    CheckerDate checkerDate;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    public List<ServiceRequest> getMany(Long vehicleId, RequestType requestType) {
        return serviceRequestRepository.findBySelectionCriteria(vehicleId, requestType);
    }

    public ResponseEntity<ServiceRequest> getOne(Long id) {
        Optional<ServiceRequest> serviceRequest = serviceRequestRepository.findById(id);
        return serviceRequest.isPresent() ? ResponseEntity.ok(serviceRequest.get()) : ResponseEntity.notFound().build();
    }

    @Override
    public ServiceRequest add(ServiceRequest entity) {
        if (checkerDate.twoRangeDateNotOverlap(entity.getStart(), entity.getEnd()) == true) {
            entity = serviceRequestRepository.save(entity);
            applicationEventPublisher.publishEvent(new AddedRequestService(this, entity));
        }
        return entity;
    }

    public ServiceRequest update(Long id, ServiceRequest entity) {
        Optional<ServiceRequest> serviceRequest = serviceRequestRepository.findById(id);
        return serviceRequest.isPresent() && checkerDate.twoRangeDateNotOverlapWithId(serviceRequest.get().getStart(), serviceRequest.get().getEnd(), id) == true ?
                this.assignProperties(serviceRequest, entity) : null;
    }

    private ServiceRequest assignProperties(Optional<ServiceRequest> serviceRequest, ServiceRequest entity) {
        ServiceRequest sr = serviceRequest.get();
        sr.setVehicleId(entity.getVehicleId());
        sr.setRequestType(entity.getRequestType());
        sr.setDescription(entity.getDescription());
        sr.setRepairStation(entity.getRepairStation());
        sr.setStart(entity.getStart());
        sr.setEnd(entity.getEnd());
        return serviceRequestRepository.save(sr);
    }

    public ResponseEntity<ServiceRequest> remove(Long id) {
        Optional<ServiceRequest> serviceRequest = serviceRequestRepository.findById(id);
        if (serviceRequest.isPresent()) {
            serviceRequestRepository.deleteById(id);
            return ResponseEntity.ok(serviceRequest.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
