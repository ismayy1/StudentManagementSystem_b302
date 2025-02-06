package com.tpe.service;

import com.tpe.domain.AppLog;
import com.tpe.dto.AppLogDTO;
import com.tpe.enums.AppLogLevel;
import com.tpe.repository.AppLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppLogService {

    private AppLogRepository appLogRepository;

    public AppLog saveAppLog(AppLogDTO appLogDTO) {
        AppLog appLog = new AppLog();

        appLog.setLevel(AppLogLevel.enumFromString(appLogDTO.getLevel()));
        appLog.setDescription(appLogDTO.getDescription());
        appLog.setCreatedAt(appLogDTO.getCreatedAt());

        return appLogRepository.save(appLog);
    }
}
