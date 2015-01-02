import com.mongodb.MongoClient;
import domain.MongoClientFactory;
import insert.NoSqlAddressInsertAdapter;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import services.sqlcrud.CreateService;

public class ServicesBinder extends AbstractBinder {

    @Override
    protected void configure() {

        //For No-SQL database
        bindFactory(MongoClientFactory.class)
                .to(MongoClient.class);
        bindAsContract(NoSqlAddressInsertAdapter.class)
                .to(services.nosqlcrud.CreateService.class);
        //For SQL database
        bindAsContract(SqlAddressInsertAdapter.class)
                .to(services.sqlcrud.CreateService.class);

    }
}
