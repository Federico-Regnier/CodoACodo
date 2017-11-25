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
public enum nivelAcceso {
    NivelUno("Administrador", 1),
    NivelDos("Administrador de Contenido",  2),
    NivelTres("Usuario", 3);
    
    private final String rol;
    private final Integer nivel;
    
    private nivelAcceso(String rol, Integer nivel){
        this.rol = rol;
        this.nivel = nivel;
    }
    
    public Integer getNivel(){ return this.nivel;}
    public String getRol(){ return this.rol;}
    
    public static nivelAcceso from(Integer i){
        for (nivelAcceso n : nivelAcceso.values()) {
            if (n.getNivel() == i) {
                return n;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return this.rol;
    }
}
