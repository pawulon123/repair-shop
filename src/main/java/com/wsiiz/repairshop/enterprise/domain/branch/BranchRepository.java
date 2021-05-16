package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<ServiceRequest, Long> {
}
