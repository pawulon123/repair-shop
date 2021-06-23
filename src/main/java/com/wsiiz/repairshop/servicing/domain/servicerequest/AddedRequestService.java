package com.wsiiz.repairshop.servicing.domain.servicerequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AddedRequestService extends ApplicationEvent {
    private final ServiceRequest serviceRequest;
    private  ArrayList<String> whereHaveIBeen = new ArrayList<String>() ;

    public AddedRequestService(Object source, ServiceRequest serviceRequest) {
        super(source);
        this.serviceRequest = serviceRequest;
    }
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setWhereHaveIBeen(String objectTooString) {
        this.whereHaveIBeen.add(objectTooString);
    }
}


