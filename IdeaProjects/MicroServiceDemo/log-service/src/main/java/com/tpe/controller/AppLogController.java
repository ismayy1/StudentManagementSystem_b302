package com.tpe.controller;

import com.tpe.domain.AppLog;
import com.tpe.dto.AppLogDTO;
import com.tpe.service.AppLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/log")
@AllArgsConstructor
public class AppLogController {

    private AppLogService appLogService;

//    http://localhost:8085/log + POST + JSON RequestBody

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLog(@RequestBody AppLogDTO appLogDTO) {
        AppLog appLog = appLogService.saveAppLog(appLogDTO);
        System.out.println(appLog);

        Map<String, Object> map = new HashMap<>();
        map.put("logBody", appLog.getDescription());

        return new ResponseEntity<>(map, HttpStatus.CREATED); // 201
    }
}
