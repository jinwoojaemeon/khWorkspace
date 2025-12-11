package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "BOARD")
@Check(constraints = "status IN ('Y','N')")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long board_id;

    @Column(length = 100, nullable = false)
    private String board_title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_writer", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Lob
    @Column(nullable = false)
    private String board_content;

    @Column(length = 100)
    private String origin_name;

    @Column(length = 100)
    private String change_name;

    @Builder.Default
    @Column(columnDefinition = "INT DEFAULT 0")
    private int count = 0;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime create_date;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private String status = "Y";
}
