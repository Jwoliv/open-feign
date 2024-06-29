package org.example.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "special_record")
public class SpecialRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "old_id", nullable = false, unique = true)
    private Long oldId;

    public SpecialRecord(String title, LocalDateTime createdAt, Long oldId) {
        this.title = title;
        this.createdAt = createdAt;
        this.oldId = oldId;
    }
}