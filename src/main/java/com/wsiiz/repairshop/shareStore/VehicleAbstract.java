package com.wsiiz.repairshop.shareStore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.vehicleFile.domain.Ownership;
import com.wsiiz.repairshop.vehicleFile.domain.body.Body;
import com.wsiiz.repairshop.vehicleFile.domain.chassis.Chassis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "VEHICLE")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class VehicleAbstract extends BaseEntity {
    VehicleType vehicleType;
    String brand;
    String model;
    String registrationNumber;
    String insurance;
    LocalDate productionDate;
    String vin;
    StatusSchedule statusSchedule;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "body_Id")
    @JsonIgnore
    public Body body;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chassis_Id")
    @JsonIgnore
    public Chassis chassis;

    @OneToMany(mappedBy = "vehicle")
    Set<Ownership> vehiclesOwners;

}
