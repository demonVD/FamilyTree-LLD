package com.familytree.Gender;

import com.familytree.Exception.GenderNotDefined;
import com.familytree.Utility.Constants;

public class GenderCreator {

    /**
     * @param genderType string specifying gender type
     * @return an instance of specified gender
     */
    public static GenderInterface getGender(String genderType)
    {
        if(Constants.FEMALE_GENDER.equalsIgnoreCase(genderType))
        {
            return new Female();
        }
        else if(Constants.MALE_GENDER.equalsIgnoreCase(genderType))
        {
            return new Male();
        }
        else
        {
            throw new GenderNotDefined();
        }
    }
}
