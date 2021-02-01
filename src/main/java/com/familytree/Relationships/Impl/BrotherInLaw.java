package com.familytree.Relationships.Impl;

import com.familytree.Gender.Impl.Male;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipCreator;
import com.familytree.Relationships.RelationshipInterface;
import com.familytree.Utility.Constants;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a brother-in-law relationship in familytree
 */
public class BrotherInLaw implements RelationshipInterface {
    /**
     * get all brother-in-law[Spouse’s brothers, Husbands of siblings]
     *
     * @param person person whose relatives are to be generated
     * @return list of relatives
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull final PersonInterface person) {
        List<PersonInterface> brotherInLaws = new ArrayList<>();
        PersonInterface partner = person.getPartner();
        RelationshipInterface siblings = RelationshipCreator.getRelationship(Constants.SIBLINGS);
        if (partner != null) {
            List<PersonInterface> spouseSiblings = siblings.getRelatives(partner);
            for (PersonInterface child : spouseSiblings) {
                if (child.getGender() instanceof Male) {
                    brotherInLaws.add(child);
                }
            }
        }

        List<PersonInterface> personSiblings = siblings.getRelatives(person);
        for (PersonInterface sib : personSiblings) {
            if (null != sib.getPartner() && sib.getPartner().getGender() instanceof Male) {
                brotherInLaws.add(sib.getPartner());
            }
        }
        return brotherInLaws;
    }
}
