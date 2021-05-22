package com.wsiiz.repairshop.vehicleFile.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Embeddable
public class VehicleOwnerKey implements Serializable {
    @Column(name = "vehicle_id")
    Long vehicleId;

    @Column(name = "owner_id")
    Long ownerId;
}
