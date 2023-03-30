package pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.Organization;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class GetByIdOrganizationArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT Company"),
                                new Organization("Google", "IT Company"),
                                new Organization("Uber", "Deliver Company")
                        ),
                        1L,
                        Optional.of(new Organization(1L, "Intive", "IT Company"))
                ),
                Arguments.of(
                        Collections.emptyList(),
                        1L,
                        Optional.empty()
                ),
                Arguments.of(
                        Arrays.asList(
                                new Organization("Intive", "IT Company"),
                                new Organization("Google", "IT Company"),
                                new Organization("Uber", "Deliver Company")
                        ),
                        400L,
                        Optional.empty()
                )
        );
    }
}
