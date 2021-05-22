package com.wsiiz.repairshop.vehicleFile.domain.body;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
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
public class Body extends BaseEntity {

    Integer color;
    LacquerTyp lacquerTyp;
    String UpholsteryDescribe;
    Type type;

    @OneToOne()
    @JoinColumn(name = "bodyId")
    Vehicle vehicle;
}
