
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fresher extends Candidate{
    private static int idTempFr = 1;
    private Date graduationDate;     
    private String graduationRank;
    private String education;       //university where student graduated 

    public Fresher() {
        super();
    }
    
    public Fresher(String firstName, String lastName, Date birthDay, String address, String phone, String email,
                    Date graduationDate, String graduationRank, String education) {
        super(firstName, lastName, birthDay, address, phone, email, 1);
        super.setId("FR" + idTempFr++ );
        
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        SimpleDateFormat fr = new SimpleDateFormat("MM/yyyy");
        return super.toString() + "| graduationDate=" + fr.format(graduationDate) + "| graduationRank=" + graduationRank + "| education=" + education;
    }

}
