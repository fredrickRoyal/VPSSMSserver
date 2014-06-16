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
public class SchoolAttended implements Serializable {

    private String studentId;
    private String schoolId;
    private String name;
    private int duration;
    private String UOM;
    private String qualification;
    private String reasonForChange;
    private String status;

    public SchoolAttended() {
    }

    public SchoolAttended(
            String studentId,
            String schoolId,
            String name,
            int duration,
            String UOM,
            String qualification,
            String reasonForChange,
            String status) {
        this.studentId = studentId;
        this.schoolId = schoolId;
        this.name = name;
        this.duration = duration;
        this.UOM = UOM;
        this.qualification = qualification;
        this.reasonForChange = reasonForChange;
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
     * @return the schoolId
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId the schoolId to set
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the UOM
     */
    public String getUOM() {
        return UOM;
    }

    /**
     * @param UOM the UOM to set
     */
    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the reasonForChange
     */
    public String getReasonForChange() {
        return reasonForChange;
    }

    /**
     * @param reasonForChange the reasonForChange to set
     */
    public void setReasonForChange(String reasonForChange) {
        this.reasonForChange = reasonForChange;
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
