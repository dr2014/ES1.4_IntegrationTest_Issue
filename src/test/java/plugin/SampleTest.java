package plugin;

import static org.elasticsearch.common.settings.ImmutableSettings.settingsBuilder;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.test.ElasticsearchIntegrationTest;
import org.elasticsearch.test.ElasticsearchIntegrationTest.ClusterScope;
import org.elasticsearch.test.ElasticsearchIntegrationTest.Scope;
import org.junit.Test;

@ClusterScope(scope = Scope.SUITE, numDataNodes = 0)
public class SampleTest extends ElasticsearchIntegrationTest {
    static {
        ClassLoader.getSystemClassLoader()
                   .setDefaultAssertionStatus(true);
    }

    @Override
    protected Settings nodeSettings(final int nodeOrdinal) {
        // set plugin.types to load this plugin
        return settingsBuilder()
                .put(super.nodeSettings(nodeOrdinal))
                .put("plugin.types", TestESPlugin.class.getName())
                .build();        
    }

    @Test
    public void sampleTest() {
        assertTrue(true);
    }
}
