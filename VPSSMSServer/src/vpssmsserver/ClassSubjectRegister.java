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
public class ClassSubjectRegister implements Serializable {

    private String id;
    private String classId;
    private String registerId;
    private String term;
    private String academicYear;

    public ClassSubjectRegister() {
    }

    public ClassSubjectRegister(String id, String classId, String registerId, String term, String academicYear) {
        this.id = id;
        this.classId = classId;
        this.registerId = registerId;
        this.term = term;
        this.academicYear = academicYear;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the registerId
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId the registerId to set
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    /**
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return the academicYear
     */
    public String getAcademicYear() {
        return academicYear;
    }

    /**
     * @param academicYear the academicYear to set
     */
    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
}
