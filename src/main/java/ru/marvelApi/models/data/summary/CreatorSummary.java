package ru.marvelApi.models.data.summary;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class CreatorSummary extends SummaryImpl {
    private String role;

    public CreatorSummary(@JsonField(name = "resourceURI") String resourceURI, @JsonField(name = "name") String name, @JsonField(name = "type") String role) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Creator Summary{" + super.toString() + "role='" + role + '\'';
    }
}
