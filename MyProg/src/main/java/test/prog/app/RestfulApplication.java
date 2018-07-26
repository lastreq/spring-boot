package test.prog.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication(scanBasePackages = "test.prog")
@EnableAutoConfiguration
public class RestfulApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }


}