package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Female;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a daughter relationship in familytree
 */
public class Daughter implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be generated
     * @return list of daughters
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull final PersonInterface person) {
        List<PersonInterface> children = person.getChildren();
        List<PersonInterface> daughters = new ArrayList<>();
        for (PersonInterface child : children) {
            if (child.getGender() instanceof Female) {
                daughters.add(child);
            }
        }
        return daughters;
    }
}
