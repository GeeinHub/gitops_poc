package g.gitops.poc.interfaces.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @GetMapping(value = "exception1")
    public ResponseEntity exception1(){
        throw new NullPointerException("just null pointer");
    }

    @GetMapping(value = "exception2")
    public ResponseEntity exception2() throws Exception{
        throw new IllegalStateException("you encounter illegal state object here...");
    }

    @GetMapping(value = "exception3")
    public ResponseEntity exception3() throws Exception{
        throw new IllegalAccessException("ilegal access, please stop...");
    }

    @GetMapping(value = "log1")
    public ResponseEntity log1() throws Exception{
        log.info("log test 1");
        return ResponseEntity.ok("log1");
    }

    @GetMapping(value = "log2")
    public ResponseEntity log2() throws Exception{
        log.info("log test 2");
        return ResponseEntity.ok("log2");
    }

    @GetMapping(value = "log3")
    public ResponseEntity log3() throws Exception{
        log.info("log test 3");
        return ResponseEntity.ok("log3");
    }

    @GetMapping(value = "log4")
    public ResponseEntity log4() throws Exception{
        log.info("log test 4");
        return ResponseEntity.ok("log4");
    }

    @GetMapping(value = "log5")
    public ResponseEntity log5() throws Exception{
        log.info("log test 5");
        return ResponseEntity.ok("log5");
    }

    @GetMapping(value = "log6")
    public ResponseEntity log6() throws Exception{
        log.info("log test 6");
        return ResponseEntity.ok("log6");
    }

    @GetMapping(value = "log7")
    public ResponseEntity log7() throws Exception{
        log.info("log test 7");
        return ResponseEntity.ok("log7");
    }

    @GetMapping(value = "log8")
    public ResponseEntity log8() throws Exception{
        log.info("log test 8");
        return ResponseEntity.ok("log8");
    }

    @GetMapping(value = "log9")
    public ResponseEntity log9() throws Exception{
        log.info("log test 9");
        return ResponseEntity.ok("log9");
    }

    @GetMapping(value = "log10")
    public ResponseEntity log10() throws Exception{
        log.info("log test 10");
        return ResponseEntity.ok("log10");
    }
}
