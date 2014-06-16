/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.io.Serializable;

/**
 *
 * @author Royal
 */
public class Guardian extends CareTaker implements Serializable {

    private String guardianId;
    private String gender;

    public Guardian() {
    }

    public Guardian(
            String studentId,
            String guardianId,
            String firstName,
            String lastName,
            String otherName,
            String residence,
            String occupation,
            String gender,
            String contact,
            String status) {
        super();
        this.setStudentId(studentId);
        this.guardianId=guardianId;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setOtherName(otherName);
        this.setResidence(residence);
        this.setOccupation(occupation);
        this.gender=gender;
        this.setContact(contact);
        this.setStatus(status);
        
    }

    /**
     * @return the guardianId
     */
    public String getGuardianId() {
        return guardianId;
    }

    /**
     * @param guardianId the guardianId to set
     */
    public void setGuardianId(String guardianId) {
        this.guardianId = guardianId;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
