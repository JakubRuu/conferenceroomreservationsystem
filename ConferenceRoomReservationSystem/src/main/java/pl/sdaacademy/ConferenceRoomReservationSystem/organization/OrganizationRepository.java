package pl.sdaacademy.ConferenceRoomReservationSystem.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
