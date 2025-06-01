package dev.tpcoder.localstackdemo.model;

import java.util.UUID;

public record Message(UUID id, String content) {
}
