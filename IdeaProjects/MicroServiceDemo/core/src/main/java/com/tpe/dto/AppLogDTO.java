package com.tpe.dto;

import java.time.LocalDateTime;

//@Getter   //no lombok in this project
public class AppLogDTO {

    private String level;
    private String description;
    private LocalDateTime createdAt;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
