package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Male;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * represent maternal-uncle relationship in familyTree
 */
public class MaternalUncle implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of maternal-uncles[mother's brother]
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull final PersonInterface person) {
        List<PersonInterface> relatives = new ArrayList<>();
        PersonInterface mother = person.getMother();
        if (mother != null) {
            PersonInterface grandMother = mother.getMother();
            if (grandMother != null) {
                List<PersonInterface> children = grandMother.getChildren();
                for (PersonInterface child : children) {
                    if (child.getGender() instanceof Male) {
                        relatives.add(child);
                    }
                }
            }
        }
        return relatives;
    }
}
