package ru.levelp.at.lesson12.design.patterns.builder;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson12.design.patterns.builder.PersonWithBuilder.Builder;

class PersonBuilderTest {

    static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(PersonWithBuilder.builder()
                                          .email("hjdshdjsa")
                                          .lastName("asadasd")
                                          .firstName("owoeiwe")),
            Arguments.of(PersonWithBuilder.builder()
                                          .age(12)
                                          .lastName("asadasd")
                                          .firstName("owoeiwe")),
            Arguments.of(PersonWithBuilder.builder()
                                          .email("hjdshdjsa")
                                          .age(12)
                                          .firstName("owoeiwe")),
            Arguments.of(PersonWithBuilder.builder()
                                          .email("hjdshdjsa")
                                          .age(12)
                                          .lastName("asadasd")),
            Arguments.of(PersonWithBuilder.builder()
                                          .lastName("asadasd")
                                          .firstName("owoeiwe")),
            Arguments.of(PersonWithBuilder.builder()
                                          .email("hjdshdjsa")
                                          .firstName("owoeiwe")),
            Arguments.of(PersonWithBuilder.builder()
                                          .email("hjdshdjsa")
                                          .lastName("asadasd"))
        );
    }

    @Test
    void builder() {
        PersonWithBuilder person = PersonWithBuilder.builder()
                                                    .email("hjdshdjsa")
                                                    .age(12)
                                                    .lastName("asadasd")
                                                    .firstName("owoeiwe")
                                                    .build();

        System.out.println(person);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void builderWithDataProvider(Builder builder) {
        System.out.println(builder.build());
    }
}
