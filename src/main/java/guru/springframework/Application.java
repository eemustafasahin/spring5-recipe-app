package guru.springframework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args)
    {
        log.debug("Hello, Spring Framework. I'm @Slf4j");
        SpringApplication.run(Application.class, args);

    }

}
