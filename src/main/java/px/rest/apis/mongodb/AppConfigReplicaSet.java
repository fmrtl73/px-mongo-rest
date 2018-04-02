package px.rest.apis.mongodb;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.ArrayList;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.*;

@Configuration
@Profile("replicaset")
public class AppConfigReplicaSet {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
   */
   public @Bean MongoClient mongoClient() {
     List<ServerAddress> serverAddresses = new ArrayList<>();
     try{
       String svcName = System.getenv().getOrDefault("mongodb_svc_name", "localhost");
       System.out.println("\n\nInitializing with svcName = " + svcName);
       if(svcName == null){
         System.out.println("mongSvcName not set in environment properties, choosing default of px-mongodb-replicaset");
         svcName = "px-mongodb-replicaset";
       }
       InetAddress[] addresses = InetAddress.getAllByName(svcName);

       for(int i=0; i<addresses.length; i++){
         System.out.println("Adding Address = " + addresses[i].getHostAddress());
         serverAddresses.add(new ServerAddress(addresses[i].getHostAddress()));
       }
     } catch(UnknownHostException e){
       System.out.println("Exception thrown: " + e.toString());
       serverAddresses.add(new ServerAddress(System.getProperty("mongoSvcName")));
     }
     System.out.println("returning serverAddresses = " + serverAddresses.toString());
     return new MongoClient(serverAddresses);

   }
}
