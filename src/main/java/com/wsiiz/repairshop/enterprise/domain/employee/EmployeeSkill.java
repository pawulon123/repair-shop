package com.wsiiz.repairshop.enterprise.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(exclude = "employee")
@NoArgsConstructor

public class EmployeeSkill extends BaseEntity {
    Long skillId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    Employee employee;

}
