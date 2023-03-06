package ru.levelp.at.lesson0809.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class PassportData {

    private String series;
    private String number;
    private String placeOfIssue;
    private String dateOfIssue;
    private String departmentCode;
}
