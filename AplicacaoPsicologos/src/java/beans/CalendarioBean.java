/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author marc
 */
@Named(value = "CalendarioBean")

public class CalendarioBean implements Serializable {

    public CalendarioBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(Integer psychologistId) {
        this.psychologistId = psychologistId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getPsychologistDesc() {
        return psychologistDesc;
    }

    public void setPsychologistDesc(String psychologistDesc) {
        this.psychologistDesc = psychologistDesc;
    }

    public String getClientDesc() {
        return clientDesc;
    }

    public void setClientDesc(String clientDesc) {
        this.clientDesc = clientDesc;
    }
    
    private Integer id;
    private String video;
    private String description;
    private String score;
    private String start_time;
    private Integer status;
    private Integer packageId;
    private Integer psychologistId;
    private Integer clientId;
    private String packageDesc;
    private String psychologistDesc;
    private String clientDesc;
}
