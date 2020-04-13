import com.google.common.collect.Sets;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

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

    @RequestMapping("/test")
    String test() {
        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                300L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                new ThreadFactoryBuilder().setNameFormat("tsetTasl-pool-%d").build(),
                new ThreadPoolExecutor.DiscardPolicy());
        IntStream.range(1, 100).forEach(item -> executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            System.out.println(Thread.currentThread().getName());
        }));
        return "test over";
    }

    @RequestMapping("/string")
    String string() {
        Set<String> sets = Sets.newHashSet();
        String[] result = sets.toArray(new String[0]);
        System.out.println(result);
        Boolean b1 = sets.isEmpty();
        sets.add("test1");
        sets.add("test2");
        String[] result2 = sets.toArray(new String[0]);
        System.out.println(result2);
        Boolean b2 = sets.isEmpty();
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
