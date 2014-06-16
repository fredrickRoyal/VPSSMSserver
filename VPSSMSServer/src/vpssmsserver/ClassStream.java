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
public class ClassStream implements Serializable {

    private String streamId;
    private String name;
    private String status;
    private String date;

    public ClassStream() {
    }

    public ClassStream(String streamId, String name) {
        this.streamId = streamId;
        this.name = name;
    }

    public ClassStream(String streamId, String name, String status, String date) {
        this.streamId = streamId;
        this.name = name;
        this.status = status;
        this.date = date;
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
