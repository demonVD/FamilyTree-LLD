package com.familytree.Relationships;

import com.familytree.Gender.Male;
import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Son implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of all sons
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
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
