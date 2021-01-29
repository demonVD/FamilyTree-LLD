package com.familytree.Relationships;

import com.familytree.Gender.Female;
import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Daughter implements RelationshipInterface{

    /**
     * @param person person whose relatives are to be generated
     * @return list of daughters
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
        List<PersonInterface> children = person.getChildren();
        List<PersonInterface> daughters = new ArrayList<>();
        for(PersonInterface child : children)
        {
            if(child.getGender() instanceof Female)
            {
                daughters.add(child);
            }
        }
        return daughters;
    }
}
