package com.familytree.Client;

import com.familytree.Gender.Female;
import com.familytree.Manager.PersonManager;
import com.familytree.Utility.Constants;

import java.io.*;

public class DriverClass {
    public static void main(String[] args)
    {
        if(args.length == 0) {
            System.out.println(Constants.NO_ARGUMENTS_PROVIDED);
            return;
        }

        // extracting input file path from argument
        String inputFilePath = args[0].trim();

        // initializing the family tree
        PersonManager personManager = new PersonManager();
        personManager.addChild("Shan", Constants.MALE_GENDER);
        personManager.addChild("Anga", Constants.FEMALE_GENDER);
        personManager.setPartner("Anga", "Shan");
        personManager.addChild("Anga", "Chit", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Ish", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Vich", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Aras", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Satya", Constants.FEMALE_GENDER);
        personManager.addChild( "Amba", Constants.FEMALE_GENDER);
        personManager.setPartner("Chit", "Amba");
        personManager.addChild("Amba", "Dritha", Constants.FEMALE_GENDER);
        personManager.addChild("Amba", "Tritha", Constants.FEMALE_GENDER);
        personManager.addChild("Amba", "Vritha", Constants.MALE_GENDER);
        personManager.addChild("Jaya", Constants.MALE_GENDER);
        personManager.setPartner("Dritha", "Jaya");
        personManager.addChild("Dritha", "Yodhan", Constants.MALE_GENDER);
        personManager.addChild("Lika", Constants.FEMALE_GENDER);
        personManager.setPartner("Vich", "Lika");
        personManager.addChild("Lika", "Vila", Constants.FEMALE_GENDER);
        personManager.addChild("Lika", "Chika", Constants.FEMALE_GENDER);
        personManager.addChild("Chitra", Constants.FEMALE_GENDER);
        personManager.setPartner("Chitra", "Aras");
        personManager.addChild("Arit", Constants.MALE_GENDER);
        personManager.addChild("Chitra","Ahit",Constants.MALE_GENDER);;
        personManager.addChild("Chitra","Jnki",Constants.FEMALE_GENDER);
        personManager.setPartner("Jnki", "Arit");
        personManager.addChild("Jnki","Laki",Constants.MALE_GENDER);
        personManager.addChild("Jnki","Lavnya",Constants.FEMALE_GENDER);
        personManager.addChild("Vyan",Constants.MALE_GENDER);
        personManager.setPartner("Vyan", "Satya");
        personManager.addChild("Satya","Asva",Constants.MALE_GENDER);
        personManager.addChild("Satya","Vyas",Constants.MALE_GENDER);
        personManager.addChild("Satya","Atya",Constants.FEMALE_GENDER);
        personManager.addChild("Satvy",Constants.FEMALE_GENDER);
        personManager.setPartner("Asva", "Satvy");
        personManager.addChild("Krpi",Constants.FEMALE_GENDER);
        personManager.setPartner("Vyas","Krpi");
        personManager.addChild("Satvy","Vasa",Constants.MALE_GENDER);
        personManager.addChild("Krpi","Kriya",Constants.MALE_GENDER);
        personManager.addChild("Krpi","Krithi",Constants.FEMALE_GENDER);

        // reading input file and calling appropriate function after each line
        File inputFile = new File(inputFilePath);
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\s+");
                String function = split[0];
                if(Constants.ADD_CHILD_FN_SIG.equalsIgnoreCase(function))
                {
                    System.out.println(personManager.addChild(split[1], split[2], split[3]).getResponse());
                }
                else if(Constants.GET_RELATIONSHIP_FN_SIG.equalsIgnoreCase(function))
                {
                    System.out.println(personManager.getRelationship(split[1], split[2]).getResponse());
                }
                else
                {
                    System.out.println(Constants.INVALID_COMMAND_IN_FILE);
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
        catch (IOException ex) {
            System.out.println(Constants.UNABLE_TO_READ_FILE);
        }
    }
}
