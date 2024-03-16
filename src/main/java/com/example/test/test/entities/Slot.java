package com.example.test.test.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "slot")
public class Slot
{
    @Id
    @Column(length = 32)
    private String id;

    @ManyToOne
    private ScheduleTemplate scheduleTemplate;

    private ZonedDateTime beginTime;
    private ZonedDateTime endTime;

    @PrePersist
    private void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
