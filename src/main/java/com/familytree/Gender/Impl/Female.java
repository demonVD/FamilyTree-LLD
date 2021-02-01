package com.familytree.Gender.Impl;

import com.familytree.Gender.GenderInterface;

/**
 * Represent Gender type : female
 */
public class Female implements GenderInterface {
    @Override
    public GenderInterface getGender() {
        return this;
    }
}
