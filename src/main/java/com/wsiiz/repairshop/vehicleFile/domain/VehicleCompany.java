package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.shareStore.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("COMPANY")
public class VehicleCompany extends Vehicle {
    Long responsibleEmployeeId;
    Long branchId;

}
