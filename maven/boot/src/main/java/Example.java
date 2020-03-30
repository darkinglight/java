import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@EnableAutoConfiguration
public class Example {
    @RequestMapping("/")
    String home() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(() -> {
            System.out.println("sub start");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {}
            System.out.println("sub end");
        });
        return "Home";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
