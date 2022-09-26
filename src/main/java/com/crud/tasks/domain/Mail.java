package com.crud.tasks.domain;

import lombok.*;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
@Builder
public class Mail {
    private final String mailTo;
    private final String subject;
    private final Optional<String> toCc;
    private final String message;

}
