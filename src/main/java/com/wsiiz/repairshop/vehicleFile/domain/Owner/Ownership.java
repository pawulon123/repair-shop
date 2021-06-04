package com.wsiiz.repairshop.vehicleFile.domain.Owner;

import com.wsiiz.repairshop.vehicleFile.domain.Vehicle;
import com.wsiiz.repairshop.vehicleFile.domain.VehicleOwnerKey;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor

public class Ownership {
    @EmbeddedId
    VehicleOwnerKey id;

    @ManyToOne
    @MapsId("vehicleId") //with joinColumn
    @JoinColumn(name = "vehicle_id")
//    @JsonIgnore
    Vehicle vehicle;

    @ManyToOne
    @MapsId("ownerId")
    @JoinColumn(name = "owner_id")
//    @JsonIgnore
    Owner owner;

}
