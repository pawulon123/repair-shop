package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query(value = "select v from Vehicle v where (:vin = null or v.vin = :vin)"
            + "and (:registrationNumber = null or v.registrationNumber = :registrationNumber)")
    List<Vehicle> findByCriteria(@Param("vin") String vin, @Param("registrationNumber") String registrationNumber
    );


}
