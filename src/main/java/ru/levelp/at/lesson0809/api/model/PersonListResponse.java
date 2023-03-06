package ru.levelp.at.lesson0809.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonListResponse {

    private List<PersonData> data;
}
