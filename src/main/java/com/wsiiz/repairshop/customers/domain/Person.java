package com.wsiiz.repairshop.customers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PERSON")
public class Person extends Customer{
    String name;
    String surName;
    LocalDate birthDate;
    String pesel;
}
