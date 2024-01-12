
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Candidate {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate() {
    }
    
    public Candidate(String firstName, String lastName, Date birthDay, String address, String phone, String email, int candidateType) {
//        this.id = candidateType + "K" + idTemp++;       // vd: _K1 ; _K2; ...
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        SimpleDateFormat fr = new SimpleDateFormat("dd/MM/yyyy");
        return "id=" + id + "| name=" + firstName +" "+ lastName + "| birthDay=" + fr.format(birthDay) + "| address=" + address + "| phone=" + phone + "| email=" + email;
    }    
    
}
