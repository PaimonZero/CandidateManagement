
package model;

import java.util.Date;

public class Experience extends Candidate{
    private static int idTempEx = 1;
    private int experienceYear;     //String
    private String proSkill;

    public Experience() {
        super();
    }
    
    public Experience(String firstName, String lastName, Date birthDay, String address, String phone, String email, int experienceYear, String proSkill) {
        super(firstName, lastName, birthDay, address, phone, email, 0);
        super.setId("EX" + idTempEx++ );
        
        this.experienceYear = experienceYear;
        this.proSkill = proSkill;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString() + "| experienceYear=" + experienceYear + "| proSkill=" + proSkill;
    }

}
