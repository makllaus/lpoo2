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
@Named(value = "HorarioBean")

public class HorarioBean implements Serializable {

    public HorarioBean() {
    }

    public HorarioBean(Integer id, String interview_start_period, String interview_end_period, Boolean foi_efetuado, Integer id_psicologo) {
        this.id = id;
        this.interview_start_period = interview_start_period;
        this.interview_end_period = interview_end_period;
        this.foi_efetuado = foi_efetuado;
        this.id_psicologo = id_psicologo;
    }

    
    private Integer id;
    private String interview_start_period;
    private String interview_end_period;
    private Boolean foi_efetuado;
    private Integer id_psicologo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterview_start_period() {
        return interview_start_period;
    }

    public void setInterview_start_period(String interview_start_period) {
        this.interview_start_period = interview_start_period;
    }

    public String getInterview_end_period() {
        return interview_end_period;
    }

    public void setInterview_end_period(String interview_end_period) {
        this.interview_end_period = interview_end_period;
    }

    public Boolean getFoi_efetuado() {
        return foi_efetuado;
    }

    public void setFoi_efetuado(Boolean foi_efetuado) {
        this.foi_efetuado = foi_efetuado;
    }

    public Integer getId_psicologo() {
        return id_psicologo;
    }

    public void setId_psicologo(Integer id_psicologo) {
        this.id_psicologo = id_psicologo;
    }
    

}
