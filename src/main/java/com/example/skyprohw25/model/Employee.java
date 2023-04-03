package com.example.skyprohw25.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {

    @JsonProperty("firstName")
    private final String name;
    @JsonProperty("lastName")
    private final String surName;

    public Employee(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getName().equals(employee.getName()) && getSurName().equals(employee.getSurName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName());
    }

    @Override
    public String toString() {
        return String.format ("Фамилия Имя: %s %s", name, surName);

    }
}
