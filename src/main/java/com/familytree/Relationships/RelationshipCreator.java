package com.familytree.Relationships;

import com.familytree.Exception.RelationshipNotFound;
import com.familytree.Relationships.Impl.*;
import com.familytree.Utility.Constants;
import lombok.NonNull;

/**
 * A factory class
 * generates relationship
 */
public class RelationshipCreator {

    /**
     * @param relationship relationship type
     * @return an instance of specified relationship
     */
    public static RelationshipInterface getRelationship(@NonNull final String relationship) {
        switch (relationship)
        {
            case Constants.BROTHER_IN_LAW:
                return new BrotherInLaw();
            case Constants.DAUGHTER:
                return new Daughter();
            case Constants.MATERNAL_AUNT:
                return new MaternalAunt();
            case Constants.MATERNAL_UNCLE:
                return new MaternalUncle();
            case Constants.PATERNAL_AUNT:
                return new PaternalAunt();
            case Constants.PATERNAL_UNCLE:
                return new PaternalUncle();
            case Constants.SIBLINGS:
                return new Siblings();
            case Constants.SISTER_IN_LAW:
                return new SisterInLaw();
            case Constants.SON:
                return new Son();
            default:
                throw new RelationshipNotFound();
        }
    }
}
