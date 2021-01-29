package com.familytree.Relationships;

import com.familytree.Gender.Male;
import com.familytree.Person.PersonInterface;
import com.familytree.Utility.Constants;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BrotherInLaw implements RelationshipInterface{
    /**
     * get all brother-in-law[Spouse’s brothers, Husbands of siblings]
     * @param person person whose relatives are to be generated
     * @return list of relatives
     */
    @Override
    public List<PersonInterface> getRelatives(@NonNull PersonInterface person) {
        List<PersonInterface> brotherInLaws = new ArrayList<>();
        PersonInterface partner = person.getPartner();
        RelationshipInterface siblings = RelationshipCreator.getRelationship(Constants.SIBLINGS);
        if(partner != null)
        {
            List<PersonInterface> spouseSiblings = siblings.getRelatives(partner);
            for(PersonInterface child : spouseSiblings)
            {
                if(child.getGender() instanceof Male)
                {
                    brotherInLaws.add(child);
                }
            }
        }

        List<PersonInterface> personSiblings = siblings.getRelatives(person);
        for(PersonInterface sib : personSiblings)
        {
            if(null != sib.getPartner() && sib.getPartner().getGender() instanceof Male)
            {
                brotherInLaws.add(sib.getPartner());
            }
        }
        return brotherInLaws;
    }
}
