package com.example.test.test.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shedule_template")
public class ScheduleTemplate
{
    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "uuid2")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date creationDate;

}
