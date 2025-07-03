package com.example.eTestCenter.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleCreationalRequest {
    private String dot;
    private String address;
    private int registration_count;
    private int max_count;
}
