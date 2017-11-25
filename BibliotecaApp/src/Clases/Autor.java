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
public class Autor {
    private Integer id;
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;
    private String nacionalidad;
    
    public Autor(Integer id, String nombre, Integer nacim, Integer fallecim, String nacionalidad){
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacim;
        this.fallecimiento = fallecim;
        this.nacionalidad = nacionalidad;
    }
    
    public Autor(String nombre, Integer nacim, Integer fallecim, String nacionalidad){
        this(0, nombre, nacim, fallecim, nacionalidad);
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nacimiento
     */
    public Integer getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the fallecimiento
     */
    public Integer getFallecimiento() {
        return fallecimiento;
    }

    /**
     * @param fallecimiento the fallecimiento to set
     */
    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
