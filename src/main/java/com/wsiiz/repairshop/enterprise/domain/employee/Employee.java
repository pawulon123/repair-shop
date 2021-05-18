package com.wsiiz.repairshop.enterprise.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "branch")
public class Employee extends BaseEntity {
    String name;
    String surName;
        @Enumerated(value = EnumType.STRING)
    TypeEmployment typeEmployment;
    LocalDateTime dateEmployment;


        @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<EmployeeSkill> skills;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "branch_id")
        @JsonIgnore
    Branch branch;


}
