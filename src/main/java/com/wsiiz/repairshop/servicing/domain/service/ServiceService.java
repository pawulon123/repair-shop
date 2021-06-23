package com.wsiiz.repairshop.servicing.domain.service;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import com.wsiiz.repairshop.servicing.domain.servicerequest.RequestType;
import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceService implements AbstractService<Service> {

    @Autowired
    ServiceFactory serviceFactory;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service add(Service service) {
        service.setTasks(serviceFactory.switchInitialTasksPolicy(service).generateTasks(service));
        return serviceRepository.save(service);
    }

    public List<Service> getMany(String description) {

        if (description == null) {
            return serviceRepository.findAll();
        } else {
            return serviceRepository.findByDescription(description);
        }
    }
    public ResponseEntity<Service> getOne (Long id){
        Optional<Service> service = serviceRepository.findById(id);
        return service.isPresent() ? ResponseEntity.ok(service.get()) : ResponseEntity.notFound().build();
    }
    public ResponseEntity<Service> remove(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            serviceRepository.deleteById(id);
            return ResponseEntity.ok(service.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
