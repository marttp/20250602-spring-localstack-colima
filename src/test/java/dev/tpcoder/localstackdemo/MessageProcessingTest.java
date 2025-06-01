package dev.tpcoder.localstackdemo;

import dev.tpcoder.localstackdemo.model.Message;
import dev.tpcoder.localstackdemo.model.config.ApplicationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.Duration;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class MessageProcessingTest {

    @Autowired
    StorageService storageService;

    @Autowired
    MessagePublisher publisher;

    @Autowired
    ApplicationProperties properties;

    @Test
    void shouldHandleMessageSuccessfully() {
        Message message = new Message(UUID.randomUUID(), "Hello World");
        publisher.publish(properties.queueName(), message);

        await().pollInterval(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(10))
                .ignoreExceptions()
                .untilAsserted(() -> {
                    String msg = storageService.downloadAsString(
                            properties.bucketName(), message.id().toString());
                    assertThat(msg).isEqualTo("Hello World");
                });
    }
}
