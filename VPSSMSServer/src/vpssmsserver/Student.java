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
public class Student implements Serializable {

    private String studentId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String photo;
    private String gender;
    private String birthPlace;
    private String DOB;
    private String district;
    private String residence;
    private String nationality;
    private String religion;
    private String disability;
    private String admissionDate;
    private String contact;
    private String status;
    private byte[] imageData;

    public Student() {
    }

    public Student(
            String studentId,
            String firstName,
            String lastName,
            String otherName,
            byte[] imageData) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.imageData = imageData;
    }
     public Student(
            String studentId,
            String firstName,
            String lastName,
            String otherName,
            byte[] imageData,
            String gender,
            String birthPlace,
            String DOB,
            String district,
            String residence,
            String nationality,
            String religion,
            String disability,
            String admissionDate,
            String contact,
            String status) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.imageData = imageData;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.DOB = DOB;
        this.district = district;
        this.residence = residence;
        this.nationality = nationality;
        this.religion = religion;
        this.disability = disability;
        this.admissionDate = admissionDate;
        this.contact = contact;
        this.status = status;
    }

    public Student(
            String studentId,
            String firstName,
            String lastName,
            String otherName,
            String photo,
            String gender,
            String birthPlace,
            String DOB,
            String district,
            String residence,
            String nationality,
            String religion,
            String disability,
            String admissionDate,
            String contact,
            String status) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.photo = photo;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.DOB = DOB;
        this.district = district;
        this.residence = residence;
        this.nationality = nationality;
        this.religion = religion;
        this.disability = disability;
        this.admissionDate = admissionDate;
        this.contact = contact;
        this.status = status;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the otherName
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * @param otherName the otherName to set
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
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

    /**
     * @return the birthPlace
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * @param birthPlace the birthPlace to set
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the residence
     */
    public String getResidence() {
        return residence;
    }

    /**
     * @param residence the residence to set
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the religion
     */
    public String getReligion() {
        return religion;
    }

    /**
     * @param religion the religion to set
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * @return the disability
     */
    public String getDisability() {
        return disability;
    }

    /**
     * @param disability the disability to set
     */
    public void setDisability(String disability) {
        this.disability = disability;
    }

    /**
     * @return the admissionDate
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @param admissionDate the admissionDate to set
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the imageData
     */
    public byte[] getImageData() {
        return imageData;
    }

    /**
     * @param imageData the imageData to set
     */
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
