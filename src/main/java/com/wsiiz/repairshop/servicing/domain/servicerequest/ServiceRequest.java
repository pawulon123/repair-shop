package com.wsiiz.repairshop.servicing.domain.servicerequest;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.wsiiz.repairshop.shareStore.RepairStation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class ServiceRequest extends BaseEntity {

    public ServiceRequest() {
        this.registrationTime = LocalDateTime.now();
    }

    Long vehicleId;

    @Enumerated(value = EnumType.STRING)
    RequestType requestType;

    String description;

    LocalDateTime registrationTime;

    @Enumerated(value = EnumType.STRING)
    RepairStation repairStation;

    LocalDateTime start;

    LocalDateTime end;
}
