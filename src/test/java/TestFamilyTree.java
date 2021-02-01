import com.familytree.Manager.PersonManager;
import com.familytree.Utility.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFamilyTree {

    private static final PersonManager personManager = new PersonManager();

    @BeforeAll
    public static void test() {
        personManager.addChild("Shan", Constants.MALE_GENDER);
        personManager.addChild("Anga", Constants.FEMALE_GENDER);
        personManager.setPartner("Anga", "Shan");
        personManager.addChild("Anga", "Chit", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Ish", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Vich", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Aras", Constants.MALE_GENDER);
        personManager.addChild("Anga", "Satya", Constants.FEMALE_GENDER);
        personManager.addChild("Amba", Constants.FEMALE_GENDER);
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
        personManager.addChild("Chitra", "Ahit", Constants.MALE_GENDER);
        ;
        personManager.addChild("Chitra", "Jnki", Constants.FEMALE_GENDER);
        personManager.setPartner("Jnki", "Arit");
        personManager.addChild("Jnki", "Laki", Constants.MALE_GENDER);
        personManager.addChild("Jnki", "Lavnya", Constants.FEMALE_GENDER);
        personManager.addChild("Vyan", Constants.MALE_GENDER);
        personManager.setPartner("Vyan", "Satya");
        personManager.addChild("Satya", "Asva", Constants.MALE_GENDER);
        personManager.addChild("Satya", "Vyas", Constants.MALE_GENDER);
        personManager.addChild("Satya", "Atya", Constants.FEMALE_GENDER);
        personManager.addChild("Satvy", Constants.FEMALE_GENDER);
        personManager.setPartner("Asva", "Satvy");
        personManager.addChild("Krpi", Constants.FEMALE_GENDER);
        personManager.setPartner("Vyas", "Krpi");
        personManager.addChild("Satvy", "Vasa", Constants.MALE_GENDER);
        personManager.addChild("Krpi", "Kriya", Constants.MALE_GENDER);
        personManager.addChild("Krpi", "Krithi", Constants.FEMALE_GENDER);
    }

    @Test
    @DisplayName("TEST : ADD_CHILD")
    public void childAdditionTest() {
        assertEquals(Constants.CHILD_ADDITION_SUCCEEDED,
                personManager.addChild("Chitra", "Aria", Constants.FEMALE_GENDER).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Brother-in-law")
    public void getBrotherInLaw() {
        assertEquals("Asva", personManager.getRelationship("Krpi", Constants.BROTHER_IN_LAW).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Maternal-Aunt")
    public void getMaternalAuntTest() {
        assertEquals(Constants.EMPTY_LIST,
                personManager.getRelationship("Lavnya", Constants.MATERNAL_AUNT).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Daughter")
    public void getDaughter() {
        assertEquals("Lavnya", personManager.getRelationship("Arit", Constants.DAUGHTER).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Maternal-Uncle")
    public void getMaternalUncle() {
        assertEquals(Constants.EMPTY_LIST, personManager.getRelationship("Tritha", Constants.MATERNAL_UNCLE).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Paternal-Uncle")
    public void getPaternalUncle() {
        assertEquals("Chit Ish Vich", personManager.getRelationship("Jnki", Constants.PATERNAL_UNCLE).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Paternal-Aunt")
    public void getPaternalAunt() {
        assertEquals("Satya", personManager.getRelationship("Jnki", Constants.PATERNAL_AUNT).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Siblings")
    public void getSiblingRelationTest() {
        assertEquals("Ahit Jnki", personManager.getRelationship("Aria", Constants.SIBLINGS).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Sister-in-law")
    public void getSisterInLaw() {
        assertEquals("Krpi", personManager.getRelationship("Asva", Constants.SISTER_IN_LAW).getResponse());
    }

    @Test
    @DisplayName("TEST : GET_RELATIONSHIP Son")
    public void getSon() {
        assertEquals("Vasa", personManager.getRelationship("Asva", Constants.SON).getResponse());
    }
}
