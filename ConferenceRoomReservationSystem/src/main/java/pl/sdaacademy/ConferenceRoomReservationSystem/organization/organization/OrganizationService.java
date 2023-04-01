package pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sdaacademy.ConferenceRoomReservationSystem.organization.SortType;

import java.util.List;
import java.util.NoSuchElementException;

@Service
class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    List<Organization> getAllOrganizations(SortType sortType) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortType.name()), "name");
        return organizationRepository.findAll(sort);
    }

    Organization getOrganization(String name) {
        return organizationRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("No organization exists!"));
    }


    Organization addOrganizations(Organization organization) {
        organizationRepository.findByName(organization.getName()).ifPresent(o -> {
            throw new IllegalArgumentException("organization already exists!");
        });
        return organizationRepository.save(organization);
    }

    Organization deleteOrganizations(String name) {
        Organization organization = organizationRepository.findByName(name).orElseThrow(() -> new NoSuchElementException(" "));
        organizationRepository.deleteById(organization.getId());
        return organization;
    }

    Organization
    updateOrganization(String name, Organization organization) {
        Organization organizationToUpdate = organizationRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException(""));
        if (organization.getDescription() != null) {
            organizationToUpdate.setDescription(organization.getDescription());
        }
        if (organization.getName() != null && organization.getName().equals(organizationToUpdate.getName())) {
         organizationRepository.findByName(organization.getName())
                         .ifPresent(o->{
                             throw new IllegalArgumentException("organization already exists!");
                         });
            organizationToUpdate.setName(organization.getName());
        }
        return organizationRepository.save(organizationToUpdate);

    }
}

