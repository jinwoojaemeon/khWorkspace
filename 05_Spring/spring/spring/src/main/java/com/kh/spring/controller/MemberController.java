package com.kh.spring.controller;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;
import com.kh.spring.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// bean에 class 등록하는 방법 @Component를 클레스에 부여한다.
// @Controller -> @Component + Controller 객체가 가질 수 있는 예외처리 등의 기능을 포함하는 어노테이션
@Controller
public class MemberController {
    
    /*
        직접 생성 방식 : private MemberService memberService = new memberServiceImpl();
            >> 객체간의 결합도가 높아진다. >> 구현체가 고정되어 있어 확장/교체가 어렵다.  >> 소스코드 수정이 일어날 경우 직접 변경해야하는 코드가 연쇄적으로 생긴다.
            
        DI(Dependency Injection) 의존성 주입 방식 사용
            - 객체를 직접 생성하지 않고 (new 키워드를 사용하지 않는다) 스프링 컨테이너가 관리하는 객체를 주입받아 쓰는 것이다.
            - 결합도가 낮아지고, 테스트가 용이해지고, 관심사 분리된다.(객체를 생성하고 사용하는 부분과 비즈니스 로직이 분리) >>> 유지보수성이 높아진다.

        @Autowired
        의존성 주입을 사용할 때 기술하는 어노테이션
        클래스 내에 필요한 객체를 직접 생성하지 않고 spring container가 관리하는 객체(=Bean에 등록된 객체)를 주입받아 사용할 수 있게 해준다. >> instanceof로 탐색?
        필드주입방식 / 생성자주입방식 으로 나뉘어져 있다.

        필드 주입 방식
            - 스프링 컨테이너가 객체를 먼저 생성한 후, @Autowired가 있는 필드에 의존성 주입을 따로 해준다.
                - 장점 : 코드가 간결하다
                - 단점 : 테스트가 어렵다. >> 필드 주입 방식은 객체 생성 시 의존성이 주입되지 않고 bean에서 생성 후 주입받는 방식이기 때문에
                                            테스트 진행시 임의로 객체를 생성하기 어렵다.
                        불변성 보장 불가능 >> 런타임에 값이 변경될 수 있다.

        생성자 주입 방식
            - 가장 권장되는 주입 방식으로, 생성 시점에  @Autowired 어노테이션이 있는 생성자를 통해 의존성을 주입하는 방식
                - 장점 : 불변성이 보장된다.
                        테스트가 용이하다.
     */
    //@Autowired (필드 주입 방식) // 자동으로 받아서 만들어준다.
    private final MemberService memberService;  // final을 사용하여 불변성을 보장?
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired // (생성자 주입 방식) MemberController 생성자가 실행될 때 의존성 주입을 해준다.
    public MemberController(MemberService memberService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberService = memberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /*
        Spring에서 클라이언트가 보낸 정보를 받는 방법 pom데이터 타입으로

        1. HettpServletRequest를 활용해서 전달값을 가져온다.
            매서드에 매개변수로 HttpServletRequest를 작성해주면
            스프링 컨테이너가 해당 매서드를 호출할 때 자동으로 매개변수로 주입시켜준다.
    */
//  원래 하던 방식
//    @PostMapping("login.me")
//    public String login(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("userId");
//        String pw = request.getParameter("userPwd");
//        System.out.println(id);
//        System.out.println(pw);
//
//        return "index";
//    }


    // 2. Spring boot로 받는 방식 : @RequestParam 어노테이션을 활용하는 방법
    // request.getParameter(key)로 value를 추출하는 역할을 대신 해주는 어노테이션
    // 요청 parameter의 key값과 동일하게 매개변수 명을 설정해주면 @RequestParam 어노테이션을 생략해도 된다.
    /*
    @PostMapping("login.me")
    public String login(@RequestParam(value = "userId", defaultValue = "user01") String userId, String userPwd) {
        System.out.println(userId);
        System.out.println(userPwd);

        return null;
    }
    */

    // 3. 요청을 받을 때 한번에 객체로 받는 방법
    /* 객체를 이용하는 방법(@MedelAttribute 생략 가능)
       요청 시 전달값들을 담고자하는 클래스 타입의 객체를 만들어 준 뒤
       전달되는 key값과 매개변수 객체의 필드명을 동일하게 만들어주면 객체의 전달값을 매핑시켜준다.
    */
    /*
    @PostMapping("login.me")
    public String login(Member member) { //@ModelAttribute Member member
        System.out.println(member);

        return null;
    }
    */

    /*
        요청 처리 후 데이터를 담아서 응답하는 방법(포워딩 or url재요청)
        1. spring에서 제공하는 Model객체를 이용하는 방법
        포워딩을 응답뷰로 전달하고자 하는 데이터를 k-v쌍으로 담을 수 있는 영역이다.
        Model 객체에 addAttribute()로 저장 시 requsetScope에 값을 저장하게 된다.
     */
    /*
    @PostMapping("login.me")
    public String login(Member member, Model model) {
        System.out.println(member);

        model.addAttribute("memberId", member.getMemberId());
        model.addAttribute("memberPwd", member.getMemberPwd());

        return "index";
    }
    */

    /*
        2. HttpSession 이용하여 session에 바로 저장하는 방식
        HttpSession을 이용한 값 저장 후 url 재요청하기
     */
    /*
    @PostMapping("login.me")
    public String login(Member member, HttpSession session) {
        System.out.println(member);

        session.setAttribute("memberId", member.getMemberId());
        session.setAttribute("memberPwd", member.getMemberPwd());

        return "redirect:/"; // 리다이렉트 : 재요청 
    }
     */
    /*
        3. ModelAndView 객체를 이용하는 방법. ModelAndView : 데이터를 담고 return 형식까지 지정할 수 있는 객체
     */
    /*
    @PostMapping("login.me")
    public ModelAndView login(Member member, ModelAndView mv) {
        System.out.println(member);

        mv.addObject("memberId", member.getMemberId());
        mv.addObject("memberPwd", member.getMemberPwd());

        //mv.setViewName("index");  // 포워딩
        mv.setViewName("redirect:/");  // url 재요청

        return mv; // 리다이렉트 : 재요청
    }
     */
    @PostMapping("login.me")
    public ModelAndView login(String memberId, String memberPwd, HttpSession httpSession,  ModelAndView mv) {
        Member loginMember = memberService.getMemberById(memberId);
        System.out.println(loginMember);

        if(loginMember==null){ // ID가 잘못된 상태
            mv.addObject("errorMSg", "아이디를 찾을 수 없습니다.");
            mv.setViewName("common/error");
        } else if(!bCryptPasswordEncoder.matches(memberPwd, loginMember.getMemberPwd())){ // 비밀번호 오류 
            mv.addObject("errorMSg", "비밀번호를 확인해주세요.");
            mv.setViewName("common/error");
        } else{ // 로그인 성공
            httpSession.setAttribute("loginMember", loginMember);
            mv.setViewName("redirect:/");
        }
        return mv;
    }

    @GetMapping("logout.me")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("loginMember");
        httpSession.setAttribute("alertMsg", "로그아웃에 성공하였습니다");
        return "redirect:/";
    }

    @GetMapping("enrollForm.me")
    public String enrollForm() {
        return "member/enrollForm";
    }

    @GetMapping("idDulpicateCheck.me")
    @ResponseBody // return을 뷰(jsp)로 보내지 말고 HTTP 응답 바디에 그대로 담아서 보내라
    public String idDulpicateCheck(@RequestParam String checkId) {
        int count = memberService.getMemberCountById(checkId);

        return count > 0 ? "NNNNN" : "NNNNY";
    }

    @PostMapping("insert.me")
    public String joinMember(Member member, HttpSession httpSession, Model model){
        /*
            비밀번호를 사용자 입력 그대로 저장한다 -> 평문 -> 해킹의 우려와 개인정보 침해에 우려가 있다.
            Spring Security에서 지원하는 암호화 방식을 사용해서 저장/검증
         */

        String pwd = bCryptPasswordEncoder.encode(member.getMemberPwd());
        member.setMemberPwd(pwd); // 기존 비밀번호를 암호화된 비밀번호로 변경
        int result = memberService.addMember(member);


        if(result > 0){
            httpSession.setAttribute("alertMsg", "회원가입에 성공하였습니다");
            return "redirect:/";
        } else{
            model.addAttribute("errorMsg", "회원가입에 실패하였습니다");
            return "common/error";
        }
    }
    @GetMapping("myPage.me")
    public String myPage(HttpSession httpSession, Model model){
        Member loginMember = (Member) httpSession.getAttribute("loginMember");
        if(loginMember == null){
            return "redirect:/";
        }
        model.addAttribute("loginMember", loginMember);
        return "member/myPage";
    }

    @PostMapping("update.me")
    public String updateMember(Member member, HttpSession httpSession, Model model){
        int result = memberService.updateMember(member);
        if(result > 0){
            httpSession.setAttribute("alertMsg", "회원정보 수정에 성공하였습니다");
            httpSession.setAttribute("loginMember", member);
            return "redirect:/myPage.me";
        } else{
            model.addAttribute("errorMsg", "회원정보 수정에 실패하였습니다");
            return "common/error";
        }
    }

    @PostMapping("updatePwd.me")
    public String updatePwd(@RequestParam("currentPwd") String currentPwd, @RequestParam("updatePwd") String updatePwd, HttpSession httpSession, Model model){
        Member loginMember = (Member) httpSession.getAttribute("loginMember");
        System.out.println(loginMember);
        if(loginMember == null){
            return "redirect:/";
        }
        if(!bCryptPasswordEncoder.matches(currentPwd, loginMember.getMemberPwd())){
            model.addAttribute("errorMsg", "비밀번호를 확인해주세요");
            return "common/error";
        }

        String newPwd = bCryptPasswordEncoder.encode(updatePwd);
        int result = memberService.updatePwd(loginMember.getMemberId(), newPwd);
        if(result > 0){
            httpSession.setAttribute("alertMsg", "비밀번호 변경에 성공하였습니다");
            httpSession.setAttribute("loginMember", loginMember);
            return "redirect:/myPage.me";
        } else{
            model.addAttribute("errorMsg", "비밀번호 변경에 실패하였습니다");
            return "common/error";
        }
        
    }

    @PostMapping("delete.me")
    public String deleteMember(@RequestParam("memberPwd") String memberPwd, HttpSession httpSession, Model model){
        Member loginMember = (Member) httpSession.getAttribute("loginMember");
        if(loginMember == null){
            return "redirect:/";
        }
        if(!bCryptPasswordEncoder.matches(memberPwd, loginMember.getMemberPwd())){
            model.addAttribute("errorMsg", "비밀번호를 확인해주세요");
            return "common/error";
        }
        int result = memberService.deleteMember(loginMember.getMemberId());
        if(result > 0){
            httpSession.setAttribute("alertMsg", "회원탈퇴에 성공하였습니다");
            httpSession.removeAttribute("loginMember");
            return "redirect:/";
        } else{
            model.addAttribute("errorMsg", "회원탈퇴에 실패하였습니다");
            return "common/error";
        }
    }
}
