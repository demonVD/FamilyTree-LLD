package com.familytree.Relationships;

import com.familytree.Exception.RelationshipNotFound;
import com.familytree.Utility.Constants;

public class RelationshipCreator {

    /**
     * @param relationship relationship type
     * @return an instance of specified relationship
     */
    public static RelationshipInterface getRelationship(String relationship)
    {
        if(relationship.equalsIgnoreCase(Constants.BROTHER_IN_LAW))
        {
            return new BrotherInLaw();
        }
        else if(relationship.equalsIgnoreCase(Constants.DAUGHTER))
        {
            return new Daughter();
        }
        else if(relationship.equalsIgnoreCase(Constants.MATERNAL_AUNT))
        {
            return new MaternalAunt();
        }
        else if(relationship.equalsIgnoreCase(Constants.MATERNAL_UNCLE))
        {
            return new MaternalUncle();
        }
        else if(relationship.equalsIgnoreCase(Constants.PATERNAL_AUNT))
        {
            return  new PaternalAunt();
        }
        else if(relationship.equalsIgnoreCase(Constants.PATERNAL_UNCLE))
        {
            return  new PaternalUncle();
        }
        else if(relationship.equalsIgnoreCase(Constants.SIBLINGS))
        {
            return new Siblings();
        }
        else if(relationship.equalsIgnoreCase(Constants.SISTER_IN_LAW))
        {
            return new SisterInLaw();
        }
        else if(relationship.equalsIgnoreCase(Constants.SON))
        {
            return new Son();
        }
        else
        {
            throw new RelationshipNotFound();
        }
    }
}
