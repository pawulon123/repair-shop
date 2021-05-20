package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Branch extends BaseEntity {

    String name;

    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "STATIONING_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "STATIONING_CITY")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "STATIONING_POSTAL_CODE")),
            @AttributeOverride(name = "street", column = @Column(name = "STATIONING_STREET")),
            @AttributeOverride(name = "numberBuilding", column = @Column(name = "STATIONING_NUMBER_BUILDING")),
    })
    Address stationingAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "CORRESPONDENCE_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "CORRESPONDENCE_CITY")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "CORRESPONDENCE_POSTAL_CODE")),
            @AttributeOverride(name = "street", column = @Column(name = "CORRESPONDENCE_STREET")),
            @AttributeOverride(name = "numberBuilding", column = @Column(name = "CORRESPONDENCE_NUMBER_BUILDING")),
    })
    Address correspondenceAddress;

    @Enumerated(value = EnumType.STRING)
    TypeActivity typeActivity;

    Long parentId;

    Long childId;
}
