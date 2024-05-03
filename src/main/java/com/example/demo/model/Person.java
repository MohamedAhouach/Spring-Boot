package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private UUID id;
    @NotBlank
    private String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public void setUUid(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UUID getUUid() {
        return id;
    }
    public String getName() {
        return name;
    }
}
