package com.familytree.Relationships;

import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.List;

public interface RelationshipInterface {
    List<PersonInterface> getRelatives(@NonNull PersonInterface person);
}
