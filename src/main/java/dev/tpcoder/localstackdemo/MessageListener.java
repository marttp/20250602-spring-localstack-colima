package dev.tpcoder.localstackdemo;

import dev.tpcoder.localstackdemo.model.Message;
import dev.tpcoder.localstackdemo.model.config.ApplicationProperties;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class MessageListener {
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
    private final StorageService storageService;
    private final ApplicationProperties properties;

    public MessageListener(StorageService storageService, ApplicationProperties properties) {
        this.storageService = storageService;
        this.properties = properties;
    }

    @SqsListener(queueNames = {"${app.queue-name}"})
    public void handle(Message message) {
        log.info("Received message: {}", message);
        var bucketName = this.properties.bucketName();
        var key = message.id().toString();
        var inputStream = new ByteArrayInputStream(message.content().getBytes(UTF_8));
        this.storageService.upload(bucketName, key, inputStream);
    }
}
