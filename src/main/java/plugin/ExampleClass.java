package plugin;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;

public class ExampleClass {
    @Inject
    public ExampleClass(Client client) {
        // injecting the Client causes a circular dependency
    }
}
