package com.wsiiz.repairshop.enterprise.domain.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    String country;
    String city;
    String postalCode;
    String street;
    String numberBuilding;
}
