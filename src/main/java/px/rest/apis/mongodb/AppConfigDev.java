package px.rest.apis.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.*;

@Configuration
@Profile("dev")
public class AppConfigDev {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
   */
   public @Bean MongoClient mongoClient() {
       return new MongoClient("localhost");
   }
}
