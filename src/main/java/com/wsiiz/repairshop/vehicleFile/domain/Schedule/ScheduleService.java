package com.wsiiz.repairshop.vehicleFile.domain.Schedule;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import com.wsiiz.repairshop.servicing.domain.servicerequest.AddedRequestService;
import com.wsiiz.repairshop.vehicleFile.domain.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleService implements ApplicationListener<AddedRequestService> {
    @Autowired
    Schedule schedule;
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public void onApplicationEvent(AddedRequestService event) {
        this.addAfterServiceRequest(event);
    }

    private void addAfterServiceRequest(AddedRequestService event) {
        schedule.setStart(event.getServiceRequest().getStart().toLocalDate());
        schedule.setEnd(event.getServiceRequest().getEnd().toLocalDate());
        schedule.setVehicleId(event.getServiceRequest().getVehicleId());
        this.add(schedule);
        event.setWhereHaveIBeen(this.toString());
    }

    public Schedule add(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

}
