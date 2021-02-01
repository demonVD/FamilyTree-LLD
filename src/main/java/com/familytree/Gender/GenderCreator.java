package com.familytree.Gender;

import com.familytree.Exception.GenderNotDefined;
import com.familytree.Gender.Impl.Female;
import com.familytree.Gender.Impl.Male;
import com.familytree.Utility.Constants;
import lombok.NonNull;

/**
 * Factory Class
 * creates instances of GenderInterface
 */
public class GenderCreator {

    /**
     * @param genderType string specifying gender type
     * @return an instance of specified gender
     */
    public static GenderInterface getGender(@NonNull final String genderType) {
        switch (genderType) {
            case Constants.MALE_GENDER:
                return new Male();
            case Constants.FEMALE_GENDER:
                return new Female();
            default:
                throw new GenderNotDefined();
        }
    }
}
