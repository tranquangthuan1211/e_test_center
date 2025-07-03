package com.example.eTestCenter.service;

import com.example.eTestCenter.Mapper.ScheduleMapper;
import com.example.eTestCenter.dto.request.ScheduleCreationalRequest;
import com.example.eTestCenter.entity.TestSchedule;
import com.example.eTestCenter.repository.TestScheduleRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TestScheduleService {
    private TestScheduleRepository testScheduleRepository;
    private ScheduleMapper scheduleMapper;
    TestScheduleService(TestScheduleRepository testScheduleRepository, ScheduleMapper mapper){
        this.testScheduleRepository = testScheduleRepository;
        this.scheduleMapper = mapper;
    }

    public TestSchedule createSchedule(ScheduleCreationalRequest request){
        TestSchedule newSchedule = scheduleMapper.toSchedule(request);
        return testScheduleRepository.save(newSchedule);
    }
    public List<TestSchedule> getAllSchedule(){
        return testScheduleRepository.findAll();
    }
    public TestSchedule updateSchedule(String id, TestSchedule updatedSchedule) {
        return testScheduleRepository.findById(id)
                .map(existing -> {
                    existing.setDot(updatedSchedule.getDot());
                    existing.setAddress(updatedSchedule.getAddress());
                    existing.setMax_count(updatedSchedule.getMax_count());
                    existing.setRegistration_count(updatedSchedule.getRegistration_count());
                    return testScheduleRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("TestSchedule not found with id: " + id));
    }
    public void deleteSchedule(String id) {
        if (!testScheduleRepository.existsById(id)) {
            throw new RuntimeException("TestSchedule not found with id: " + id);
        }
        testScheduleRepository.deleteById(id);
    }
}
