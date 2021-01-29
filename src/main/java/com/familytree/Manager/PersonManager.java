package com.familytree.Manager;

import com.familytree.Exception.RelationshipNotFound;
import com.familytree.Gender.Female;
import com.familytree.Gender.GenderCreator;
import com.familytree.Person.PersonClass;
import com.familytree.Person.PersonInterface;
import com.familytree.Relationships.RelationshipCreator;
import com.familytree.Utility.Constants;
import com.familytree.Utility.ReturnResponse;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonManager {
    private static final Map<String, PersonInterface> personMap = new HashMap<>();

    /**
     * @param person person to be added in the family tree
     * @param father person's father
     * @param mother person's mother
     * @return a string response stating whether the operation was successful or not
     */
    private ReturnResponse addInFamilyTree(@NonNull PersonInterface person, PersonInterface father, PersonInterface mother)
    {
        if(personMap.containsKey(person.getName()))
        {
            return new ReturnResponse(Constants.PERSON_ALREADY_PRESENT);
//            throw new PersonAlreadyExists();
        }
        person.setFather(father);
        person.setMother(mother);
        personMap.put(person.getName(), person);
        return new ReturnResponse(Constants.CHILD_ADDITION_SUCCEEDED);
    }

    /**
     * @param  mother mother's name
     * @param child child's name
     * @param gender gender name
     * @return a string response stating whether the operation was successful or not
     */
    public ReturnResponse addChild(@NonNull String mother, @NonNull String child, @NonNull String gender)
    {
        if(!personMap.containsKey(mother))
        {
            return new ReturnResponse(Constants.PERSON_NOT_FOUND);
//            throw new PersonNotFound();
        }
        if(personMap.containsKey(child))
        {
            return new ReturnResponse(Constants.PERSON_ALREADY_PRESENT);
        }
        PersonInterface motherRef = personMap.get(mother);
        if(!(motherRef.getGender() instanceof Female) )
        {
            return new ReturnResponse(Constants.CHILD_ADDITION_FAILED);
        }
        PersonInterface childRef = new PersonClass(child, GenderCreator.getGender(gender));
        return addInFamilyTree(childRef, motherRef.getPartner(), motherRef);
    }

    /**
     * function to introduce person in the family tree without any link
     * @param child child's name
     * @param gender gender name
     * @return a string response stating whether the operation was successful or not
     */
    public ReturnResponse addChild(@NonNull String child, @NonNull String gender)
    {
        PersonInterface childRef = new PersonClass(child, GenderCreator.getGender(gender));
        return addInFamilyTree(childRef, null, null);
    }

    /**
     * function to get relatives of a person based on relationship
     * @param personName person's name
     * @param relationshipName  relation with person
     * @return a string response containing names of all the relatives having specified relationship to the person
     */

    public ReturnResponse getRelationship(@NonNull String personName, @NonNull String relationshipName)
    {
        if(!personMap.containsKey(personName))
        {
            return new ReturnResponse(Constants.PERSON_NOT_FOUND);
//            throw new PersonNotFound();
        }
        PersonInterface personRef = personMap.get(personName);
        List<PersonInterface> relatives = new ArrayList<>();
        try{
             relatives = RelationshipCreator.getRelationship(relationshipName).getRelatives(personRef);
        }
        catch (RelationshipNotFound ex)
        {
            return new ReturnResponse(Constants.RELATIONSHIP_NOT_FOUND);
        }
        return (relatives.size() != 0) ? generateResponseFromList(relatives) : new ReturnResponse(Constants.EMPTY_LIST);
    }

    /**
     * function to set partner1 and partner2, partner's of each other
     * @param partner1 partner1's name
     * @param partner2 partner2's name
     * @return a string response stating whether the operation was successful or not
     */
    public ReturnResponse setPartner(@NonNull String partner1, @NonNull String partner2)
    {
        if(!personMap.containsKey(partner1) || !personMap.containsKey(partner2))
        {
            return new ReturnResponse(Constants.PERSON_NOT_FOUND);
//            throw new PersonNotFound();
        }
        PersonInterface person1Ref = personMap.get(partner1);
        PersonInterface person2Ref = personMap.get(partner2);
        person1Ref.setPartner(person2Ref);
        return new ReturnResponse(Constants.SET_PARTNER_SUCCESS);
    }

    /**
     * function to generate response
     * @param relatives list of all relatives
     * @return response containing name of all relatives
     */
    private ReturnResponse generateResponseFromList(List<PersonInterface> relatives)
    {
        StringBuilder response = new StringBuilder();
        for(PersonInterface person : relatives)
        {
            response.append(person.getName()).append(" ");
        }
        response.deleteCharAt(response.length()-1);
        return new ReturnResponse(response.toString());
    }


}
