package com.kh.jdbc.run;

import com.kh.jdbc.view.MemberMenu;

/*
 * MVC 패턴 
 *  각 관심사(역할)에 따라서 레이어를 분리해서 작성하는 구조
 *  Model : 도메인 상태와 규칙(vo, dao, entity, 레포지토리...)
 *  View : 화면에 표현하는 역할, 사용자와의 의사소통(콘솔에 출력, 브라우저 화면...) 
 *  Controller : 사용자의 의도 해석, 흐름을 제어(요청을 직접적으로 받아 기능을 처리하는 역할)
 *  
 *  -MVC 패턴을 사용하는 이유 
 *   하나의 클래스 또는 하나의 패키지에 작성을 하게되면 유지보수가 어렵고, 재사용성이 떨어지고, 테스트가 어렵다.
 *   -> 기능의 분리가 되어있지 않고, 하나의 매서드에서 전부 처리하기 때문이다.
 */
public class Run {

	public static void main(String[] args) {
		new MemberMenu().mainMenu();
	}

}
