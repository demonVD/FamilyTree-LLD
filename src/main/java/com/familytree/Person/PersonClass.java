package com.familytree.Person;

import com.familytree.Gender.GenderInterface;

import java.util.ArrayList;
import java.util.List;

public class PersonClass implements PersonInterface{

    private final String name;
    private PersonInterface partner;
    private final List<PersonInterface> children;
    private PersonInterface father;
    private PersonInterface mother;
    private final GenderInterface gender;

    public PersonClass(String name, GenderInterface gender) {
        this.name = name;
        this.gender = gender;
        children = new ArrayList<>();
        this.father = null;
        this.mother = null;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setFather(PersonInterface father)
    {
        if(father != null)
        {
            this.father = father;
            this.father.addChild(this);
            return;
        }
        this.father = null;
    }
    @Override
    public void setMother(PersonInterface mother)
    {
        if(mother != null)
        {
            this.mother = mother;
            this.mother.addChild(this);
            return;
        }
        this.mother = null;
    }

    @Override
    public void setPartner(PersonInterface partner)
    {
        this.partner = partner;
        if(partner.getPartner() == this) return;
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
    public PersonInterface getMother()
    {
        return this.mother;
    }

    @Override
    public GenderInterface getGender()
    {
        return this.gender.getGender();
    }

    @Override
    public void addChild(PersonInterface child)
    {
        children.add(child);
    }

    @Override
    public void addChildren(List<PersonInterface> children)
    {
        this.children.addAll(children);
    }

    @Override
    public List<PersonInterface> getChildren()
    {
        return this.children;
    }
}
