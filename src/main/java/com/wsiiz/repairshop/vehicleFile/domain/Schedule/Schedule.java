package com.wsiiz.repairshop.vehicleFile.domain.Schedule;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.servicing.domain.servicerequest.AddedRequestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Slf4j
@Entity
@Table(name = "VEHICLE_SCHEDULE")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor

@Component
public class Schedule extends BaseEntity {

    LocalDate start;
    LocalDate end;
    Long vehicleId;

}
