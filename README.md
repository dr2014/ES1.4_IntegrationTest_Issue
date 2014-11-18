# Issue
If a plugin injects `Client` anywhere the `ElasticsearchIntegrationTest` will create a circular dependency. Example: [ExampleClass.java line 8](src/main/java/plugin/ExampleClass.java#L8)

# Run Test
To test it run `gradle test --debug`.
