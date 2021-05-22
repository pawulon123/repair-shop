package com.wsiiz.repairshop.shareStore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseAddress {
    String country;
    String city;
    String postalCode;
    String street;
    String numberBuilding;
}
