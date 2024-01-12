package controller;

import View.Validation;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CandidateManager {
    ArrayList<Candidate> candidates = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public CandidateManager() {
    }

    public void createCandidate(int candidateType) {
        while(true) {
            String fname = Validation.checkInputName(">Enter first name: ");
            String lname = Validation.checkInputName(">Enter last name: ");
            Date birthDate = Validation.checkBirthDay();
            String email = Validation.checkEmail(">Enter email: ");
            String address = Validation.getString(">Enter address: ");
            String phone = Validation.checkPhone(">Enter phone: ");
            Candidate newCandidate = new Candidate(fname, lname, birthDate, address, phone, email, candidateType);
            
            switch (candidateType) {
                case 0:
                    createExperience(newCandidate);
                    break;
                case 1:
                    createFresher(newCandidate);
                    break;
                case 2:
                    createInternship(newCandidate);
                    break;
                default:
                    throw new AssertionError();
            }
            
            if (!Validation.checkInputYN(">Do you want to continue(Y/N): ")) {
                return;
            }
        }
    }
    
    public void createExperience(Candidate newCan) {         //create an object to invoke method from Candidate.java
        int yearExperience = Validation.checkExperienceYear(">Enter year of experience: ", newCan.getBirthDay());
        
        String professionalSkill = Validation.getString(">Enter professional skill: ");
        
        Experience newEx = new Experience(newCan.getFirstName(), newCan.getLastName(), newCan.getBirthDay(), 
                            newCan.getAddress(), newCan.getPhone(), newCan.getEmail(), 
                        yearExperience, professionalSkill);
        candidates.add(newEx);
        System.out.println("=====Create success !=====");
    }
    
    public void createFresher(Candidate newCan) {         //create an object to invoke method from Candidate.java
        Date graduationDate = Validation.checkDate(">Enter graduation time(MM/YYYY): ", "MM/YYYY", newCan.getBirthDay());
        
        int rank = Validation.inputIntMinMax(">Enter graduation rank (1-Excellence, 2-Good, 3-Fair, 4-Poor): ", 1, 4);
        String graduationRank = "Poor";
        if(rank == 1) { graduationRank = "Excellence";
        } else if(rank == 2) { graduationRank = "Good";
        } else if(rank == 3) { graduationRank = "Fair";}

        String graduationSchool = Validation.getString(">Enter graduation school: ");
        
        Fresher newFr = new Fresher(newCan.getFirstName(), newCan.getLastName(), newCan.getBirthDay(), 
                            newCan.getAddress(), newCan.getPhone(), newCan.getEmail(), 
                        graduationDate, graduationRank, graduationSchool);
        candidates.add(newFr);
        System.out.println("=====Create success !=====");
    }
    
    public void createInternship(Candidate newCan) {         //create an object to invoke method from Candidate.java
        String major = Validation.getString(">Enter your major: ");
        String semester = Validation.getString(">Enter your semester: ");
        String universityName = Validation.getString(">Enter your University Name: ");
        
        Internship newIn = new Internship(newCan.getFirstName(), newCan.getLastName(), newCan.getBirthDay(), 
                            newCan.getAddress(), newCan.getPhone(), newCan.getEmail(), 
                        major, semester, universityName);
        candidates.add(newIn);
        System.out.println("=====Create success !=====");
    }
    
    //////////////////////////////////////////
    
    public void printAllList() {
        
        boolean experienceFound = false;
        System.out.print("\n==========EXPERIENCE CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                experienceFound = true;
            }
        }
        if (!experienceFound) {
            System.out.println("Empty List");
        }
        
        boolean fresherFound = false;
        System.out.print("\n==========FRESHER CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                fresherFound = true;
            }
        }
        if (!fresherFound) {
            System.out.println("Empty List");
        }
        
        boolean internshipFound = false;
        System.out.print("\n==========INTERNSHIP CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                internshipFound = true;
            }
        }
        if (!internshipFound) {
            System.out.println("Empty List");
        }
    }

    public void searchCandidate() {
        if(candidates.isEmpty()) { 
            System.out.println("No candidates have been created. Please create a candidate first !"); 
            return;
        }
        printAllList();
        System.out.println("=======================");
        String nameSearch = Validation.getString(">Enter candidate name (First name or Last name): ");

        System.out.println("===TYPE OF CANDIDATE===");
        System.out.println("0.Experience.");
        System.out.println("1.Fresher.");
        System.out.println("2.Internship.");

        int typeCandidate = Validation.inputIntMinMax("Enter type of candidate:", 0, 2);

        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateType() == typeCandidate
                    && (candidate.getFirstName().equalsIgnoreCase(nameSearch))
                    || (candidate.getLastName().equalsIgnoreCase(nameSearch)) ) {
                if(count == 0){
                    System.out.println("The Candidate Found:");
                }
                System.out.println(candidate.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not found");
        }
    }
}
