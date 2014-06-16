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
public class SubjectPaperRegister implements Serializable {

    private String id;
    private String subjectId;
    private String paperId;
    private String paperCode;
    private String status;
    private String academicYear;

    public SubjectPaperRegister() {
    }

    public SubjectPaperRegister(
            String id,
            String subjectId,
            String paperId,
            String status,
            String academicYear) {
        this.id=id;
        this.subjectId=subjectId;
        this.paperId=paperId;
        this.status=status;
        this.academicYear=academicYear;
    }
    public SubjectPaperRegister(
            String id,
            String subjectId,
            String paperId,
            String paperCode,
            String status,
            String academicYear) {
        this.id=id;
        this.subjectId=subjectId;
        this.paperId=paperId;
        this.paperCode=paperCode;
        this.status=status;
        this.academicYear=academicYear;
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
     * @return the subjectId
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return the paperId
     */
    public String getPaperId() {
        return paperId;
    }

    /**
     * @param paperId the paperId to set
     */
    public void setPaperId(String paperId) {
        this.paperId = paperId;
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

    /**
     * @return the paperCode
     */
    public String getPaperCode() {
        return paperCode;
    }

    /**
     * @param paperCode the paperCode to set
     */
    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }
}
