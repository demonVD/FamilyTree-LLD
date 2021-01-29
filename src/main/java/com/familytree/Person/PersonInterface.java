package com.familytree.Person;

import com.familytree.Gender.GenderInterface;

import java.util.List;

public interface PersonInterface {

    String getName();
    PersonInterface getPartner();
    PersonInterface getFather();
    PersonInterface getMother();
    GenderInterface getGender();

    void setPartner(PersonInterface partner);
    void setFather(PersonInterface father);
    void setMother(PersonInterface mother);
    void addChild(PersonInterface child);
    void addChildren(List<PersonInterface> children);
    List<PersonInterface> getChildren();
}
