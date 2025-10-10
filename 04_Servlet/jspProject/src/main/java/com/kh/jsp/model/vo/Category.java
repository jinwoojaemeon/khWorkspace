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

public class Category {
    private int categoryNo;        // CATEGORY_NO
    private String categoryName;   // CATEGORY_NAME
}