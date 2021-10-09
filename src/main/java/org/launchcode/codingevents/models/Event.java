package org.launchcode.codingevents.models;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.Objects;
import javax.validation.*;
import javax.validation.constraints.*;

public class Event {

    private int id;
    private static int nextId = 1;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Location is required.")
    private String location;

    @AssertTrue(message = "Registration must be required.")
    private boolean registrationRequired;

    @Positive(message = "Must be a number over zero.")
    private int maxAttendees;

    @Email(message = "Invalid Email. Try again.")
    @NotBlank(message = "Email is required.")
    private String contactEmail;

    private EventType type;

    public Event(String name, String description, String contactEmail, String location, boolean registrationRequired, int maxAttendees, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.maxAttendees = maxAttendees;
        this.type = type;

    }

    public Event(){
        this.id = nextId;
        nextId++;
    };

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

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
