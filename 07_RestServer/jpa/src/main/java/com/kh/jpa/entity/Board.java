package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "BOARD")
@Check(constraints = "status IN ('Y','N')")
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long boardId;

    @Column(length = 100, nullable = false)
    private String boardTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_writer", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Lob
    @Column(nullable = false)
    private String boardContent;

    @Column(length = 100)
    private String originName;

    @Column(length = 100)
    private String changeName;

    @Builder.Default
    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer count = 0;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private Status status = Status.Y;

    public enum Status {
        Y, N;
    }
}
