package com.wsiiz.repairshop.vehicleFile.domain.chassis;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shareStore.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Chassis extends BaseEntity {
    Long EngineId;
    Long transmissionId;
    String suspension;

    @OneToOne()
    @JoinColumn(name = "bodyId")
    Vehicle vehicle;


}
