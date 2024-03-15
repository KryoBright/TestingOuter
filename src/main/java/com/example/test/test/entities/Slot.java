package com.example.test.test.entities;

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
    @GeneratedValue(generator = "uuid2")
    private String id;

    @ManyToOne
    private ScheduleTemplate scheduleTemplate;

    private ZonedDateTime beginTime;
    private ZonedDateTime endTime;


}
