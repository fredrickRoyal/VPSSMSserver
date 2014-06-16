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
public class StudentRegister implements Serializable {

    private String registerId;
    private String studentId;
    private String classId;
    private String streamId;
    private String academicTerm;
    private String academicYear;
    private String status;

    public StudentRegister() {
    }

    public StudentRegister(
            String registerId,
            String studentId,
            String classId,
            String streamId,
            String academicTerm,
            String academicYear,
            String status) {
        this.registerId=registerId;
        this.studentId=studentId;
        this.classId=classId;
        this.streamId=streamId;
        this.academicTerm=academicTerm;
        this.academicYear=academicYear;
        this.status=status;
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
     * @return the streamId
     */
    public String getStreamId() {
        return streamId;
    }

    /**
     * @param streamId the streamId to set
     */
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    /**
     * @return the academicTerm
     */
    public String getAcademicTerm() {
        return academicTerm;
    }

    /**
     * @param academicTerm the academicTerm to set
     */
    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
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
}
