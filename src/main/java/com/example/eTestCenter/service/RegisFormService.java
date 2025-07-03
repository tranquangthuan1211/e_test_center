package com.example.eTestCenter.service;

import com.example.eTestCenter.dto.request.RegisFormCreational;
import com.example.eTestCenter.entity.RegisForm;
import com.example.eTestCenter.entity.TestSchedule;
import com.example.eTestCenter.exception.AppException;
import com.example.eTestCenter.exception.ErrorCode;
import com.example.eTestCenter.repository.RegisFormRepository;
import com.example.eTestCenter.repository.TestScheduleRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class RegisFormService {
    private RegisFormRepository regisFormRepository;
    private TestScheduleRepository testScheduleRepository;
    RegisFormService(RegisFormRepository regisFormRepository, TestScheduleRepository testScheduleRepository){
        this.regisFormRepository = regisFormRepository;
        this.testScheduleRepository = testScheduleRepository;
    }

    public RegisForm createForm(RegisFormCreational request){
        TestSchedule schedule = testScheduleRepository.findById(request.getScheduleId())
                .orElseThrow(() -> new RuntimeException("schedule not found with id: " + request.getScheduleId()));

        RegisForm form = RegisForm.builder()
                .dor(request.getDor())
                .schedule(schedule)
                .status(request.getStatus())
                .build();
        return regisFormRepository.save(form);
    }
    public List<RegisForm> getAllForm(){
        return regisFormRepository.findAll();
    }

    public RegisForm getbyId(String id){
        return regisFormRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_DATA));
    }


}
