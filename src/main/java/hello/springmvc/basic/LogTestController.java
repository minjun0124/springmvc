package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 기존 Controller 는 view name 을 반환한다.
// 한편, RestController 의 경우 return 내용을 그대로 body 에 담아서 반환.
// 아래의 경우 String type ok 가 그대로 반환된다.
@Slf4j
@RestController
public class LogTestController {

//    @Slf4j 로 대체
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // sout 같은 경우는 모든 경우에 다 출력이 된다.
        // 따라서 정확히 어떤 경우의 로그인지 알기 어려움
        // 즉, 실무에서는 sout 은 쓰지않고 Slf4j - logback 을 사용한다.
        System.out.println("name = " + name);

        // application.properties 에 logging.level.hello.springmvc=trace 와 같이
        // 입력해주면 해당 레벨부터 하위 레벨까지의 로그를 볼 수 있다.
        // 단, 지정하지 않으면 기본 level 은 info
        // 레벨 순서는 trace - debug - error - warn - info 순이다.
        log.trace(" trace log = {}", name);
        log.debug(" debug log = {}", name);
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);
        log.info(" info log = {}", name);

        // 하기와 같은 방법은 불필요한 연산으로 리소스를 잡아먹는다.
        // 사용하지 말 것.
//        log.trace(" info log =" + name);

        return "ok";
    }
}
