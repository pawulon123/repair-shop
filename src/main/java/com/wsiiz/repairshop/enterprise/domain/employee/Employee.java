package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {
    String name;
    String surName;
        @Enumerated(value = EnumType.STRING)
    TypeOfEmployment typeOfEmployment;
    LocalDateTime dateOfEmployment;
    Long branchId;
//    List<EmployeeSkill> skills

}
