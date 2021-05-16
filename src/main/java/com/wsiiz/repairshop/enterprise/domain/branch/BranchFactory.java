package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;

public class BranchFactory implements AbstractFactory <Branch>{
    @Override
    public Branch create() {
        return new Branch();
    }
}
