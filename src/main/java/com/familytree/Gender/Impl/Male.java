package com.familytree.Gender.Impl;

import com.familytree.Gender.GenderInterface;

/**
 * Represent Gender type : Male
 */
public class Male implements GenderInterface {
    @Override
    public GenderInterface getGender() {
        return this;
    }
}
