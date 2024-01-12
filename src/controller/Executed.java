package controller;

import view.Menu;

public class Executed extends Menu {
    CandidateManager mg = new CandidateManager();
    
    public Executed() {
        super("\n-*-*-*-*-CANDIDATE MANAGEMENT SYSTEM-*-*-*-*", new String[]{"Experience", "Fresher", "Internship", "Searching", "Exit"});
    }
    
    public static void main(String[] args) {
        Executed hi = new Executed();
        hi.run();
    }

    @Override
    public void execute(int ch) {
        switch(ch) {
            case 1:
                mg.createCandidate(0);
                break;
            case 2:
                mg.createCandidate(1);
                break;
            case 3:
                mg.createCandidate( 2);
                break;
            case 4:
                mg.searchCandidate();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

}
