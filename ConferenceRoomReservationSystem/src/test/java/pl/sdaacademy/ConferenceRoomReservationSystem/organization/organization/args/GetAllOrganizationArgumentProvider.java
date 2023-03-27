package pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.Organization;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class GetAllOrganizationArgumentProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(new Organization("intive", "IT Company"),
                                new Organization("Google", "IT Company"),
                                new Organization("Uber", "Deliver Company")
                        ),
                        Arrays.asList(new Organization("intive", "IT Company"),
                                new Organization("Google", "IT Company"),
                                new Organization("Uber", "Deliver Company")
                        )
                ),
                Arguments.of(Collections.emptyList(), Collections.emptyList())
        );
    }
}

