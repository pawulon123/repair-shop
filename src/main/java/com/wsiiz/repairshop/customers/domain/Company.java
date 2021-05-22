package com.wsiiz.repairshop.customers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("COMPANY")
public class Company extends Customer {
    String name;
    String Regon;
    @Enumerated(EnumType.STRING)
    ActivityType activityType;
}
