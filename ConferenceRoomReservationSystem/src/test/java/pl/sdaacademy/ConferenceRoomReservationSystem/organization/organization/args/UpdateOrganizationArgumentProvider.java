package pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.args;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization.Organization;

import java.util.stream.Stream;

public class UpdateOrganizationArgumentProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                //name
                //existing org
                // to update
                // expected
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization(null, "IT company"),
                        new Organization("Initive", "IT company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization("Tieto", null),
                        new Organization("Tieto", "Delivery company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization("Tieto", "IT company"),
                        new Organization("Tieto", "IT company")
                ),
                Arguments.of(
                        "Intive",
                        new Organization("Intive", "Delivery company"),
                        new Organization(null, null),
                        new Organization("Intive", "Deliver company")
                )
        );
    }
}
