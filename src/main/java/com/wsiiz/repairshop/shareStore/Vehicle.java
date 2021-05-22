package com.wsiiz.repairshop.shareStore;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shareStore.VehicleType;
import com.wsiiz.repairshop.vehicleFile.domain.body.Body;
import com.wsiiz.repairshop.vehicleFile.domain.chassis.Chassis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OWNER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle extends BaseEntity {
    VehicleType vehicleType;
    String brand;
    String model;
    Long ownerId;
    String registrationNumber;
    String insurance;
    LocalDate productionDate;
    Long chassisId;
    Long bodyId;
    String vin;

    @OneToOne(mappedBy = "vehicle", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Body body;

    @OneToOne(mappedBy = "vehicle", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Chassis chassis;
}
