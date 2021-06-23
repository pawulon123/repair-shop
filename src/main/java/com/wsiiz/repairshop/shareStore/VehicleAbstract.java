package com.wsiiz.repairshop.shareStore;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.vehicleFile.domain.Owner.Ownership;
import com.wsiiz.repairshop.vehicleFile.domain.body.Body;
import com.wsiiz.repairshop.vehicleFile.domain.chassis.Chassis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_id", referencedColumnName = "id")
    public Body body;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chassis_id", referencedColumnName = "id")
    public Chassis chassis;

    @OneToMany(mappedBy = "vehicle")
    Set<Ownership> vehiclesOwners;
}
