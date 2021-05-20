package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.servicing.domain.servicerequest.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = "select b from Branch b where (:city = null or b.stationingAddress.city = :city)"
            + "and (:parentId = null or b.parentId = :parentId)")
    List<Branch> findByCriteria(@Param("city") String city, @Param("parentId") Long parentId
    );
}
