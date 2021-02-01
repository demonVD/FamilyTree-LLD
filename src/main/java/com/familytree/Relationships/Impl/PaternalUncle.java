package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Male;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * represent paternal-uncle relationship in familyTree
 */
public class PaternalUncle implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of paternal-uncles[father's brothers]
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull final PersonInterface person) {
        List<PersonInterface> relatives = new ArrayList<>();
        PersonInterface father = person.getFather();
        if (father != null) {
            PersonInterface grandFather = father.getFather();
            if (grandFather != null) {
                List<PersonInterface> children = grandFather.getChildren();
                for (PersonInterface child : children) {
                    if (child.getGender() instanceof Male && child != father) {
                        relatives.add(child);
                    }
                }
            }
        }
        return relatives;
    }
}
