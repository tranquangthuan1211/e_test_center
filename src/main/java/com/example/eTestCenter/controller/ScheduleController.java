package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.request.ScheduleCreationalRequest;
import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.entity.TestSchedule;
import com.example.eTestCenter.service.TestScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private TestScheduleService testScheduleService;
    ScheduleController(TestScheduleService testScheduleService){
        this.testScheduleService = testScheduleService;
    }

    @PostMapping
    ApiResponse<TestSchedule>createSchedule(@RequestBody ScheduleCreationalRequest request){
        return ApiResponse.<TestSchedule>builder()
                .data(testScheduleService.createSchedule(request))
                .message("successfully")
                .code(200)
                .build();
    }
    @GetMapping
    ApiResponse<List<TestSchedule>> getAll(){

        return ApiResponse.<List<TestSchedule>>builder()
                .code(200)
                .message("successfully")
                .data(testScheduleService.getAllSchedule())
                .build();
    }
    @PutMapping("/{id}")
    ApiResponse<TestSchedule> updateSchedule(
            @PathVariable String id,
            @RequestBody TestSchedule updatedSchedule
    ){
        return ApiResponse.<TestSchedule>builder()
                .data(testScheduleService.updateSchedule(id,updatedSchedule))
                .message("successfully")
                .code(200)
                .build();
    }
    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteSchedule(@PathVariable String id) {
        testScheduleService.deleteSchedule(id);
        return ApiResponse.<Void>builder()
                .message("successfully")
                .code(200)
                .build();
    }
}
