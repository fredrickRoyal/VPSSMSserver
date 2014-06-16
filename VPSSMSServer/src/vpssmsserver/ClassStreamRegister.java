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
public class ClassStreamRegister implements Serializable{

    private String registerId;
    private String classId;
    private String streamId;
    private String term;
    private String year;
    private String status;
    private String date;

    public ClassStreamRegister() {
    }

    public ClassStreamRegister(
            String registerId, String classId, String streamId, String term, String year, String status, String date) {
        this.registerId = registerId;
        this.classId = classId;
        this.streamId = streamId;
        this.term = term;
        this.year = year;
        this.status = status;
        this.date = date;
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
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
