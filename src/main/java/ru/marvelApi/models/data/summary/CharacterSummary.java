package ru.marvelApi.models.data.summary;

import ru.marvelApi.annotation.JsonField;

/**
 * Created by Khartonov Oleg on 13.04.2016.
 */
public class CharacterSummary extends Summary {
    private String role;

    public CharacterSummary(@JsonField(name = "resourceURI") String resourceURI, @JsonField(name = "name") String name, @JsonField(name = "type") String role) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "CharacterSummary{" +
                "resourceURI='" + resourceURI + '\'' +
                "name" + name + '\'' +
                "role='" + role + '\'' +
                '}';
    }
}
