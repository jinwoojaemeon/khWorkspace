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
@Table(name = "REPLY")
@Check(constraints = "status IN ('Y','N')")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int reply_no;

    @Column(length = 400, nullable = false)
    private String reply_content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_bno", referencedColumnName = "board_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_writer", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime create_date;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private String status = "Y";
}
