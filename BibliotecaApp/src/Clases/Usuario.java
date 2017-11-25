/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Bartok
 */
public class Usuario {
    private  Integer id;
    private String nombreCompleto;
    private String usuario;
    private Integer nivelAcceso;

    public Usuario(Integer id, String nombreCompleto, String usuario, Integer nivelAcceso){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.nivelAcceso = nivelAcceso;
    }
    
    public Usuario(String nombreCompleto, String usuario, Integer nivelAcceso){
        this(0, nombreCompleto, usuario, nivelAcceso);
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nivelAcceso
     */
    public Integer getNivelAcceso() {
        return nivelAcceso;
    }

    /**
     * @param nivelAcceso the nivelAcceso to set
     */
    public void setNivelAcceso(Integer nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
    
}
