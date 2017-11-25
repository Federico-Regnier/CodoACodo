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
public class Libro {
    private Integer id;
    private String titulo;
    private Integer anio;
    private String autor;
    private Editorial editorial;

    public Libro(Integer id, String titulo, Integer anio, String autor, Editorial editorial){
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    public Libro(String titulo, Integer anio, String autor, Editorial editorial){
        this(0, titulo, anio, autor, editorial);
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editorial
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    /**
     * 
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setEditorial(Integer anio) {
        this.anio = anio;
    }
}
