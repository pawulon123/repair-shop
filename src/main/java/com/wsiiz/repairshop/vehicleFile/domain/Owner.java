package com.wsiiz.repairshop.vehicleFile.domain;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
public class Owner extends BaseEntity {
    @OneToMany(mappedBy = "owner")
    Set<Ownership> vehiclesOwners;
}
