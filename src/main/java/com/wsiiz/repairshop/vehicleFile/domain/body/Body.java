package com.wsiiz.repairshop.vehicleFile.domain.body;

import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeSkill;
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
public class Body extends BaseEntity {

    Integer color;
    LacquerTyp lacquerTyp;
    String upholsteryDescribe;
    Type type;

    @OneToMany(mappedBy = "body", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<VehicleAbstract> vehicles;

}
