/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.Connection;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Bartok
 */
public class Biblioteca {
    private static Connection connection;
    public static void connect(){
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String pass = "admin";
        
        if(connection != null)
            return;
        
        try{
            connection = (Connection)DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Usuario login(String user, String pass){
        if(connection == null)
            return null;
        
        try {
            PreparedStatement s = connection.clientPrepareStatement("SELECT id, nombreyapellido, niveldeacceso FROM usuarios WHERE usuario = ? AND password = ?");
            s.setString(1, user);
            s.setString(2, pass);
            s.execute();
            ResultSet r = s.getResultSet();
            
            if(r.next()){
                return new Usuario(r.getInt("id"), r.getString("nombreyapellido"), user, r.getInt("niveldeacceso"));
            }
            
            return null;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static Boolean agregarUsuario(Usuario usuario, String password){
        if(usuario == null || connection == null)
            return false;
        
        try{
            String query = "INSERT INTO usuarios (nombreyapellido,usuario,password,niveldeacceso) VALUES(?,?,?,?)";
            PreparedStatement s = connection.clientPrepareStatement(query);
            s.setString(1, usuario.getNombreCompleto());
            s.setString(2, usuario.getUsuario());
            s.setString(3, password);
            s.setInt(4, usuario.getNivelAcceso());
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Boolean borrarUsuario(Integer id){
        if(id == null || id <= 0 || connection == null)
            return false;
        
        try{
            String query = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement s = connection.clientPrepareStatement(query);
            s.setInt(1, id);
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Boolean modificarUsuario(Usuario usuario){
        if(usuario == null || usuario.getId() <= 0 || connection == null)
            return false;
        
        try{
            String query = "UPDATE usuarios SET nombreyapellido = ?, usuario = ?, niveldeacceso = ? WHERE id = ?";
            PreparedStatement s = connection.clientPrepareStatement(query);
            s.setString(1, usuario.getNombreCompleto());
            s.setString(2, usuario.getUsuario());
            s.setInt(3, usuario.getNivelAcceso());
            s.setInt(4, usuario.getId());
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Boolean cambiarPass(Integer id, String pass){
        if(id == null || id <= 0 || connection == null)
            return false;
        
        try{
            String query = "UPDATE usuarios SET password= ? WHERE id = ?";
            PreparedStatement s = connection.clientPrepareStatement(query);
            s.setString(1, pass);
            s.setInt(2, id);
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static List<Usuario> getUsers(){
        if(connection == null)
            Biblioteca.connect();
        
        try{
            String query = "SELECT id, nombreyapellido, usuario, niveldeacceso FROM usuarios";
            List<Usuario> usuarios = new ArrayList<>();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                usuarios.add(new Usuario(r.getInt("id"), r.getString("nombreyapellido"), r.getString("usuario"), r.getInt("niveldeacceso")));
            }
            return usuarios;
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static Integer buscarAutor(String autor){
        if(connection == null)
            return -1;
        
        try{
            String query = "SELECT idAutores FROM autores WHERE nombre = ?";
            PreparedStatement s = connection.prepareStatement(query);
            s.setString(1, autor);
            s.execute();
            
            ResultSet r = s.getResultSet();
            if(r.next())
                return r.getInt("idAutores");
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public static List<Autor> getAutores(){
        if(connection == null)
            return null;
        
        try{
            String query = "SELECT idAutores, nombre, Anio_nac, Anio_fall, Nacionalidad FROM autores";
            List<Autor> autores = new ArrayList<>();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                autores.add(
                        new Autor(r.getInt("idAutores"), r.getString("nombre"), r.getInt("Anio_nac"), r.getInt("Anio_fall"), r.getString("Nacionalidad"))
                );
            }
            return autores;
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static Boolean agregarAutor(Autor autor){
        if(connection == null)
            Biblioteca.connect();
        
        try{
            String query = "INSERT INTO autores (nombre, Anio_nac, Anio_fall, Nacionalidad) VALUES (?,?,?,?)";
            PreparedStatement s = connection.prepareStatement(query);
            s.setString(1, autor.getNombre());
            s.setInt(2, autor.getNacimiento());
            s.setInt(3, autor.getFallecimiento());
            s.setString(4, autor.getNacionalidad());
            
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Boolean agregarEditorial(String editorial){
        if(connection == null)
            return false;
        
        try{
            String query = "INSERT INTO editoriales (EDITORIAL) VALUES (?)";
            PreparedStatement s = connection.prepareStatement(query);
            s.setString(1, editorial);
            return s.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Integer buscarEditorial(String editorial){
        if(connection == null)
            return -1;
        
        try{
            String query = "SELECT idEditoriales FROM editoriales WHERE Editorial = ?";
            PreparedStatement s = connection.prepareStatement(query);
            s.setString(1, editorial);
            
            if(s.execute()){
                ResultSet r = s.getResultSet();
                r.next();
                return r.getInt("idEditoriales");
            }
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public static List<Editorial> getEditoriales(){
        if(connection == null)
            return null;
        
        try{
            List<Editorial> editoriales = new ArrayList<>();
            String query = "SELECT * FROM editoriales";
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                editoriales.add(new Editorial(r.getInt("idEditoriales"), r.getString("Editorial")));
            }
            return editoriales;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static Boolean agregarLibro(Libro libro){
        if(libro == null || connection == null)
            return false;
        
        try{
            String query = "INSERT INTO libros (Titulo, Anio_pub, autor, editorial) VALUES(?,?,?,?)";
            Integer idAutor = Biblioteca.buscarAutor(libro.getAutor());
            
            if(idAutor > 0){
                PreparedStatement s = connection.clientPrepareStatement(query);
                s.setString(1, libro.getTitulo());
                s.setInt(2, libro.getAnio());
                s.setInt(3, idAutor);
                s.setInt(4, libro.getEditorial().getId());
                return s.executeUpdate() > 0;
            }
            System.out.println("Autor no encontrado");
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static List<Libro> getLibros(){
        if(connection == null)
            return null;
        
        try{
            String query = "SELECT idLibros, titulo, Anio_pub, autores.nombre, editoriales.Editorial "
                    +       "FROM libros "
                    +       "INNER JOIN autores ON libros.Autor = autores.idAutores "
                    +       "INNER JOIN editoriales ON libros.Editorial = editoriales.idEditoriales "
                    +       "ORDER BY idLibros";
            List<Libro> libros = new ArrayList<>();
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                libros.add(
                        new Libro(r.getInt("idLibros"), r.getString("titulo"), r.getInt("Anio_pub"), r.getString("nombre"), new Editorial(r.getString("Editorial")))
                );
            }
            return libros;
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
