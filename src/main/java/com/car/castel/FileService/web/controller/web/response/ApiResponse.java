package com.car.castel.FileService.web.controller.web.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Builder
public class ApiResponse {
    public boolean status;
    public String message;

    @CreatedDate
    public Date timestamp;

    public Object body;

    {
        this.timestamp = new Date();
    }


}
