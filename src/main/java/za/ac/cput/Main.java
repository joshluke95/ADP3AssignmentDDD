package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration

public class Main
{
    @RequestMapping({"/", "/home"})
    public String home()
    {
        return "Hello World!";
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }
}
