package com.tr.es.plugin;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestRequest.Method;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.rest.RestStatus;

public class TestESRestHandler implements RestHandler {
    
    private Client client;
    
    @Inject
    public TestESRestHandler(Settings settings, final RestController controller, Client client) {
        
        controller.registerHandler(Method.GET, "/test-action", this);  
        this.client = client;
    }

    @Override
    public void handleRequest(RestRequest request, RestChannel channel) throws Exception {
        
        ClusterHealthResponse chr = client.admin().cluster().prepareHealth().execute().actionGet();        
        
        RestResponse response = new BytesRestResponse(RestStatus.OK, "Hello from Test Action: " + chr.getClusterName());
        
        channel.sendResponse(response);
        
    }

}
