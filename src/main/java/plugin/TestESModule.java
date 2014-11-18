package plugin;

import org.elasticsearch.common.inject.AbstractModule;

public class TestESModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ExampleClass.class).asEagerSingleton();
    }
}
