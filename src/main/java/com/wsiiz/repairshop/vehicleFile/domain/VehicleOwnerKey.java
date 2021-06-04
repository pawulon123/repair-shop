package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.vehicleFile.domain.Owner.MainOwner;
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

    @Column(name = "maine_owner_id")
    Long maineOwnerId;
//or
//    @Column(name = "maine_owner")
//    Boolean maineOwner;
}
