package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "NOTICE")
public class Notice {
//    NOTICE_NO IDENTITY PRIMARY KEY, -- AUTO_INCREMENT
//    NOTICE_TITLE VARCHAR(30) NOT NULL,
//    NOTICE_WRITER VARCHAR(30) NOT NULL,
//    NOTICE_CONTENT VARCHAR(200) NOT NULL,
//    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER(USER_ID) ON DELETE CASCADE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long notice_id;

    @Column(length = 30, nullable = false)
    private String notice_title;

    @Column(length = 30, nullable = false)
    private String notice_writer;

    @Column(length = 200, nullable = false)
    private String notice_content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime create_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_writer", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;
}
