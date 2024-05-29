package org.example.subscription.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "plans")
public class Plan extends BaseModel{
    private String name;
    private String description;
    private double price;
    private int validity;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Feature> features = new HashSet<>();
@ManyToMany(mappedBy = "plans")
    private Set<Feature> features = new HashSet<>();
}
