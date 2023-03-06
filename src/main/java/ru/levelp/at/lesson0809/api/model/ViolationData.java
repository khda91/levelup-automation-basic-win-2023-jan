package ru.levelp.at.lesson0809.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@EqualsAndHashCode
public class ViolationData {

    private String code;
    private String detail;
    private String field;
}
