package com.wsiiz.repairshop.customers.domain;

import com.wsiiz.repairshop.shareStore.BaseAddress;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy =  SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE" , discriminatorType = DiscriminatorType.STRING)
public abstract class Customer extends BaseEntity {


    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "STATIONING_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "STATIONING_CITY")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "STATIONING_POSTAL_CODE")),
            @AttributeOverride(name = "street", column = @Column(name = "STATIONING_STREET")),
            @AttributeOverride(name = "numberBuilding", column = @Column(name = "STATIONING_NUMBER_BUILDING")),
    })
    BaseAddress stationingAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "CORRESPONDENCE_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "CORRESPONDENCE_CITY")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "CORRESPONDENCE_POSTAL_CODE")),
            @AttributeOverride(name = "street", column = @Column(name = "CORRESPONDENCE_STREET")),
            @AttributeOverride(name = "numberBuilding", column = @Column(name = "CORRESPONDENCE_NUMBER_BUILDING")),
    })
    BaseAddress correspondenceAddress;

    public abstract String  fullName();
}
