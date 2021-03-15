package org.quarkus.example.model;

import javax.validation.constraints.NotNull;

public class Student {

    private String id;
    @NotNull(message = "Name must be present")
    private String name;

    @NotNull(message = "Hobbies must be present")
    private String hobbies;
    private String prefix;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
