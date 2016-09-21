import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by thainguy on 8/9/2016.
 */
@SpringBootApplication
@ComponentScan("com.bagasus")
public class App {
    public static void main(String[] args){

        ClassLoader classLoader = App.class.getClassLoader();
        Config rootConf = ConfigFactory.parseResources(classLoader, "application.conf");
        System.out.print(rootConf.entrySet());

        SpringApplication.run(App.class, args);
    }
}
