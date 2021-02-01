package com.familytree.Relationships;

import com.familytree.Gender.Male;
import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MaternalUncle implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of maternal-uncles[mother's brother]
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
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
