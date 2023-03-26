package pl.sdaacademy.ConferenceRoomReservationSystem.organization.organization;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

interface AddOrganization {
}

interface UpdateOrganization {
}

@Entity
public class Organization {

    @Id
    @Size(min = 2, max = 20, groups = {AddOrganization.class, UpdateOrganization.class})
    @NotBlank(groups = AddOrganization.class)
    private String name;

    private String description;

    public Organization() {
    }


    public Organization(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}