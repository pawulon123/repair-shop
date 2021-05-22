package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.shareStore.StatusSchedule;
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
@DiscriminatorValue("CUSTOMER")

public class VehicleCustomer extends Vehicle {
    StatusSchedule statusSchedule;
}
