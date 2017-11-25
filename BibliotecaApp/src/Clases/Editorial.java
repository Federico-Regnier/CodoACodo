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
public class Editorial {
    private Integer id;
    private String editorial;

    public Editorial(Integer id, String editorial){
        this.id =  id;
        this.editorial = editorial;
    }
    
    public Editorial(String editorial){
        this.editorial = editorial;
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
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    @Override
    public String toString(){
        return this.getEditorial();
    }
}
