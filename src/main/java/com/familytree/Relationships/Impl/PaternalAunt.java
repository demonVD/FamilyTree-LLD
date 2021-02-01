package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Female;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * represent paternal-aunt relationship in familyTree
 */
public class PaternalAunt implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of paternal-aunt[father's sisters]
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
                    if (child.getGender() instanceof Female) {
                        relatives.add(child);
                    }
                }
            }
        }
        return relatives;
    }
}
