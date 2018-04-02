package px.rest.apis.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.*;

@Configuration
@Profile("prod")
public class AppConfigProd {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
   */
   public @Bean MongoClient mongoClient() {
       return new MongoClient(System.getenv().getOrDefault("mongodb_svc_name", "localhost"));
   }
}
