package com.familytree.Person.Impl;

import com.familytree.Gender.GenderInterface;
import com.familytree.Person.PersonInterface;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a person
 */
public class PersonClass implements PersonInterface {

    private final String name;
    private PersonInterface partner;
    private final List<PersonInterface> children;
    private PersonInterface father;
    private PersonInterface mother;
    private final GenderInterface gender;

    public PersonClass(@NonNull final String name,@NonNull final GenderInterface gender) {
        this.name = name;
        this.gender = gender;
        children = new ArrayList<>();
        this.father = null;
        this.mother = null;
        this.partner = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setFather(final PersonInterface father) {
        if (father != null) {
            this.father = father;
            this.father.addChild(this);
            return;
        }
        this.father = null;
    }

    @Override
    public void setMother(final PersonInterface mother) {
        if (mother != null) {
            this.mother = mother;
            this.mother.addChild(this);
            return;
        }
        this.mother = null;
    }

    @Override
    public void setPartner(@NonNull final PersonInterface partner) {
        this.partner = partner;
        if (partner.getPartner() == this) return;
        partner.setPartner(this);
    }

    @Override
    public PersonInterface getPartner() {
        return this.partner;
    }

    @Override
    public PersonInterface getFather() {
        return this.father;
    }

    @Override
    public PersonInterface getMother() {
        return this.mother;
    }

    @Override
    public GenderInterface getGender() {
        return this.gender.getGender();
    }

    @Override
    public void addChild(@NonNull final PersonInterface child) {
        children.add(child);
    }

    @Override
    public void addChildren(@NonNull final List<PersonInterface> children) {
        this.children.addAll(children);
    }

    @Override
    public List<PersonInterface> getChildren() {
        return this.children;
    }
}
