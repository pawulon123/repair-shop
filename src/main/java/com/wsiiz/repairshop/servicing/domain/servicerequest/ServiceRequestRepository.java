package com.wsiiz.repairshop.servicing.domain.servicerequest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.wsiiz.repairshop.shareStore.RepairStation;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    @Query(value = "select sr from ServiceRequest sr where (:vehicleId = null or sr.vehicleId = :vehicleId) "
            + "and (:requestType = null or sr.requestType = :requestType)")
    List<ServiceRequest> findBySelectionCriteria(@Param("vehicleId") Long vehicleId,
                                                 @Param("requestType") RequestType requestType);

    @Query(value = "SELECT count(*) FROM Service_Request sr WHERE  (sr.start <= ?2 AND sr.end >= ?1) ", nativeQuery = true)
    Integer checkAvailabilityOfDates(
            LocalDateTime start,
            LocalDateTime end

    );

    @Query(value = "SELECT count(*) FROM Service_Request sr WHERE sr.start <= ?2 AND sr.end >= ?1 AND sr.id != ?3", nativeQuery = true)
    Integer checkAvailabilityOfDates(
            LocalDateTime start,
            LocalDateTime end,
            Long id
    );

}
