package g.gitops.poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
//@EnableJms
public class FePocApplication {
    public static void main(String[] args) {
        SpringApplication.run(FePocApplication.class, args);
//        log.info("Started");
    }

}
