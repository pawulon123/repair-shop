package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VehicleCustomerRepository extends JpaRepository<VehicleCustomer, Long> {
    @Query(value = "select v from Vehicle v where (:vin = null or v.vin = :vin)"
            + "and (:registrationNumber = null or v.registrationNumber = :registrationNumber)")
    List<VehicleCustomer> findByCriteria(@Param("vin") String vin, @Param("registrationNumber") String registrationNumber
    );

}
