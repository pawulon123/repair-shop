package com.wsiiz.repairshop.vehicleFile.domain.chassis;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shareStore.VehicleAbstract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Chassis extends BaseEntity {
    Long engineId;
    Long transmissionId;
    String suspension;

    @OneToOne(mappedBy = "chassis")
    VehicleAbstract vehicle;
}
