
package model;

import java.util.Date;

public class Internship extends Candidate{
    private static int idTempIn = 1;
    private String majors;     
    private String semester;
    private String university;       //university where student study

    public Internship() {
        super();
    }
    
    public Internship(String firstName, String lastName, Date birthDay, String address, String phone, String email,
                    String majors, String semester, String university) {
        super(firstName, lastName, birthDay, address, phone, email, 2);
        super.setId("IN" + idTempIn++ );
        
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString() + "| majors=" + majors + "| semester=" + semester + "| university=" + university;
    }
}
