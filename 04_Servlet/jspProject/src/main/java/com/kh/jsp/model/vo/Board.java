package com.kh.jsp.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Board {
    private int boardNo;
    private String boardType;
    private int categoryNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private int count;
    private Date createDate;
    private String status;

    public static Board insertBoard(String category, String title, String content, String upfile, String memberId) {
        Board b = new Board();
        //b.setCategoryNo(category);  // to-do
        b.setBoardTitle(title);
        b.setBoardContent(content);
        b.setBoardWriter(upfile);
        b.setBoardWriter(memberId);
        return b;
    }
}
