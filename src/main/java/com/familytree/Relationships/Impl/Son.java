package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Male;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * represent son relationship in familyTree
 */
public class Son implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of all sons
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull final PersonInterface person) {
        List<PersonInterface> children = person.getChildren();
        List<PersonInterface> sons = new ArrayList<>();
        for (PersonInterface child : children) {
            if (child.getGender() instanceof Male) {
                sons.add(child);
            }
        }
        return sons;
    }
}
