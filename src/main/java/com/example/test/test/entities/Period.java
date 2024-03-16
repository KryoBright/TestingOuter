package com.example.test.test.entities;

import com.example.test.test.enums.SlotType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "period")
public class Period
{
    @Id
    @Column(length = 32)
    private String id;

    @OneToOne
    private Slot slot;

    @ManyToOne
    private Schedule schedule;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private SlotType slotType;

    @ManyToOne
    private Employee administrator;

    @ManyToOne
    @JoinColumn(name = "executor_id", nullable = true)
    private Employee executor;

    @PrePersist
    private void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
