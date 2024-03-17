package com.example.test.test.models.entities;

import com.example.test.test.models.enums.Position;
import com.example.test.test.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

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
    private String id;

    private String employeeName;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Position position;

    @PrePersist
    private void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString().replace("-", "");
        }
    }
    //Чтобы генерировался id до вставки в таблицу
}
