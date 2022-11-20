package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {


    private Long id;
    private String title;
    private String content;

    public TaskDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
