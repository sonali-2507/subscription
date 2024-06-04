package org.example.subscription.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "plans")
public class Plan extends BaseModel{
    private String name;
    private String description;
    private double price;
    //I want to rename validity as validityInMonths

    private int validityInMonths;

    @ManyToMany(mappedBy = "plans")
    private Set<Feature> features = new HashSet<>();
}
