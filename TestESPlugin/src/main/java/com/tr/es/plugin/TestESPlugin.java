package com.tr.es.plugin;

import java.util.Arrays;
import java.util.Collection;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;

public class TestESPlugin extends AbstractPlugin {    

    public String name() {
        return "test-plugin";
    }

    public String description() {
        return "Test plugin";
    }
    
    public Collection<Class<? extends Module>> modules() {
        return Arrays.asList(TestESModule.class);
    }      
    
}

