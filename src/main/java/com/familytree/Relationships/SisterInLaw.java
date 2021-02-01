package com.familytree.Relationships;

import com.familytree.Gender.Female;
import com.familytree.Person.PersonInterface;
import com.familytree.Utility.Constants;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SisterInLaw implements RelationshipInterface {

    /**
     * @param person person whose relatives are to be returned
     * @return list of all sister-in-laws [spouse's sisters, wives of siblings]
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
        List<PersonInterface> sistersInLaws = new ArrayList<>();
        PersonInterface partner = person.getPartner();
        RelationshipInterface siblings = RelationshipCreator.getRelationship(Constants.SIBLINGS);

        if (partner != null) {
            List<PersonInterface> spouseSiblings = siblings.getRelatives(partner);
            for (PersonInterface child : spouseSiblings) {
                if (child.getGender() instanceof Female) {
                    sistersInLaws.add(child);
                }
            }
        }

        List<PersonInterface> personSiblings = siblings.getRelatives(person);
        for (PersonInterface sib : personSiblings) {
            if (null != sib.getPartner() && sib.getPartner().getGender() instanceof Female) {
                sistersInLaws.add(sib.getPartner());
            }
        }
        return sistersInLaws;
    }
}
