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
public class StudentResult implements Serializable {

    private String id;
    private String studentId;
    private String subjectId;
    private String paperId;
    private String paperName;
    private String term;
    private String academicYear;
    private int holidayWork;
    private int BOT;
    private int midTerm;
    private int EOT;
    private String status;

    public StudentResult() {
    }
       public StudentResult(
            String id,
            String studentId,
            String subjectId,
            String paperName,
            String paperId,
            String term,
            String academicYear,
            int holidayWork,
            int BOT,
            int midTerm,
            int EOT,
            String status) {
        this.id=id;
        this.studentId=studentId;
        this.subjectId=subjectId;
        this.paperName=paperName;
        this.paperId=paperId;
        this.term=term;
        this.academicYear=academicYear;
        this.holidayWork=holidayWork;
        this.BOT=BOT;
        this.midTerm=midTerm;
        this.EOT=EOT;
        this.status=status;
    }

    public StudentResult(
            String id,
            String studentId,
            String subjectId,
            String paperId,
            String term,
            String academicYear,
            int holidayWork,
            int BOT,
            int midTerm,
            int EOT,
            String status) {
        this.id=id;
        this.studentId=studentId;
        this.subjectId=subjectId;
        this.paperId=paperId;
        this.term=term;
        this.academicYear=academicYear;
        this.holidayWork=holidayWork;
        this.BOT=BOT;
        this.midTerm=midTerm;
        this.EOT=EOT;
        this.status=status;
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

    /**
     * @return the holidayWork
     */
    public int getHolidayWork() {
        return holidayWork;
    }

    /**
     * @param holidayWork the holidayWork to set
     */
    public void setHolidayWork(int holidayWork) {
        this.holidayWork = holidayWork;
    }

    /**
     * @return the BOT
     */
    public int getBOT() {
        return BOT;
    }

    /**
     * @param BOT the BOT to set
     */
    public void setBOT(int BOT) {
        this.BOT = BOT;
    }

    /**
     * @return the midTerm
     */
    public int getMidTerm() {
        return midTerm;
    }

    /**
     * @param midTerm the midTerm to set
     */
    public void setMidTerm(int midTerm) {
        this.midTerm = midTerm;
    }

    /**
     * @return the EOT
     */
    public int getEOT() {
        return EOT;
    }

    /**
     * @param EOT the EOT to set
     */
    public void setEOT(int EOT) {
        this.EOT = EOT;
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
     * @return the paperName
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * @param paperName the paperName to set
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
