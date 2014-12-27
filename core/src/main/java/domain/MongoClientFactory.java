package domain;

import com.mongodb.MongoClient;
import org.glassfish.hk2.api.Factory;

import java.net.UnknownHostException;

public class MongoClientFactory implements Factory<MongoClient> {

    @Override
    public MongoClient provide() {
        try {
            return new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void dispose(MongoClient mongoClientFactory) {

    }
}
