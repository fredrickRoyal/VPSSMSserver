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
public class Parent extends CareTaker implements Serializable {

    private String parentId;
    private String relationship;

    public Parent() {
    }

    public Parent(
            String studentId,
            String parentId,
            String firstName,
            String lastName,
            String otherName,
            String residence,
            String occupation,
            String relationship,
            String contact,
            String status) {
        super();
        this.setStudentId(studentId);
        this.parentId = parentId;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setOtherName(otherName);
        this.setResidence(residence);
        this.setOccupation(occupation);
        this.relationship = relationship;
        this.setContact(contact);
        this.setStatus(status);

    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
