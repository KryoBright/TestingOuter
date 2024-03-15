package com.example.test.test.entities;

import com.example.test.test.enums.Position;
import com.example.test.test.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee
{
    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "uuid2")
    private String id;

    private String employeeName;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Position position;
}
