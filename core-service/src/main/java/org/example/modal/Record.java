package org.example.modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    public Record(String title, LocalDateTime createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }
}
