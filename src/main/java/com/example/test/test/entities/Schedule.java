package com.example.test.test.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shedule")
public class Schedule
{
    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "uuid2")
    private String id;

    @Column(nullable = true)
    private String schedule_name;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime creationDate;
}
