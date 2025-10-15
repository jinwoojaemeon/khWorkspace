package com.kh.jsp.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Board {
    private int boardNo;           // BOARD_NO
    private int boardType;         // BOARD_TYPE (1: 일반, 2: 사진)
    private int categoryNo;        // CATEGORY_NO
    private String categoryName;   // 조인용 (CATEGORY 테이블에서 가져옴)
    private String boardTitle;     // BOARD_TITLE
    private String boardContent;   // BOARD_CONTENT
    private int boardWriter;       // BOARD_WRITER (회원번호)
    private int count;             // COUNT (조회수)
    private String memberId;       // 조인용 (MEMBER 테이블에서 가져옴)
    private String status;         // STATUS
    private String createDate;     // CREATE_DATE
}
