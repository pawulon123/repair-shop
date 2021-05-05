package com.wsiiz.repairshop.servicing.domain.service;

import javax.persistence.Embeddable;
import lombok.Data;

import java.time.LocalTime;

@Embeddable
@Data
public class Employee {

  Long employeeId;
  String employeeName;
  LocalTime hireData;
}
