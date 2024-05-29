package org.example.subscription.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.subscription.models.Feature;

import java.util.Set;
@Getter
@Setter
public class FeatureDto {
    private Set<Feature> featureSet;
}
