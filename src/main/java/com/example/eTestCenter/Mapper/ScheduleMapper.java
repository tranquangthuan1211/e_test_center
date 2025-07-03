package com.example.eTestCenter.Mapper;

import com.example.eTestCenter.dto.request.ScheduleCreationalRequest;
import com.example.eTestCenter.entity.TestSchedule;
import com.example.eTestCenter.repository.TestScheduleRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    TestSchedule toSchedule(ScheduleCreationalRequest request);
}
