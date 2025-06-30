package com.example.eTestCenter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Phản hồi chuẩn từ API")
public class ApiResponse<T> {

    @Schema(example = "200", description = "Mã trạng thái")
    int code;

    @Schema(example = "register successfully", description = "Thông điệp phản hồi")
    String message;

    @Schema(description = "Dữ liệu thực tế trả về")
    T data;
}
