package com.example.eTestCenter.controller;

import com.example.eTestCenter.dto.request.RegisFormCreational;
import com.example.eTestCenter.dto.response.ApiResponse;
import com.example.eTestCenter.entity.RegisForm;
import com.example.eTestCenter.service.RegisFormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class RegisFormController {
    private RegisFormService regisFormService;
    RegisFormController(RegisFormService regisFormService){
        this.regisFormService = regisFormService;
    }

    @PostMapping
    ApiResponse<RegisForm> createForm(@RequestBody RegisFormCreational request){

        return ApiResponse.<RegisForm>builder()
                .data(regisFormService.createForm(request))
                .code(200)
                .message("successfully")
                .build();
    }
    @GetMapping
    ApiResponse<List<RegisForm>> getAllForm(){

        return ApiResponse.<List<RegisForm>>builder()
                .data(regisFormService.getAllForm())
                .code(200)
                .message("successfully")
                .build();
    }
    @GetMapping("/{id}")
    ApiResponse<RegisForm> getById(@PathVariable String id){

        return ApiResponse.<RegisForm>builder()
                .data(regisFormService.getbyId(id))
                .code(200)
                .message("successfully")
                .build();
    }


}
