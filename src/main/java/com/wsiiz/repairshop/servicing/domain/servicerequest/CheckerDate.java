package com.wsiiz.repairshop.servicing.domain.servicerequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Slf4j
@Component()
public class CheckerDate {

    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    public Boolean twoRangeDateNotOverlap(LocalDateTime dateStart, LocalDateTime dateEnd) {
        return serviceRequestRepository.checkAvailabilityOfDates(dateStart, dateEnd) != 0 ? this.except400("Provide correct RequestService term") : true;
    }

    public Boolean twoRangeDateNotOverlapWithId(LocalDateTime dateStart, LocalDateTime dateEnd, Long id) {
        return serviceRequestRepository.checkAvailabilityOfDates(dateStart, dateEnd, id) != 0 ? this.except400("Provide correct RequestService term") : true;

    }

    public Boolean except400(String message) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);

    }
}
