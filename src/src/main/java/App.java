import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by thainguy on 8/9/2016.
 */
@SpringBootApplication
@ComponentScan("pegasus")
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
