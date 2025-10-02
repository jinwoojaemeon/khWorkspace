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
 /* Category Table 구조
  * CATEGORY_NO CATEGORY_NAME
  * 10	공통
	20	운동
	30	등산
	40	게임
	50	낚시
	60	요리
	70	기타
  * */
 	private int categoryNo;
 	private String categoryName;

}
