package com.familytree.Relationships;

import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Siblings implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be calculated
     * @return list of all siblings
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
        List<PersonInterface> siblings = new ArrayList<>();
        PersonInterface father = person.getFather();
        if (father != null) {
            List<PersonInterface> children = father.getChildren();
            for (PersonInterface child : children) {
                if (child != person) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }
}
