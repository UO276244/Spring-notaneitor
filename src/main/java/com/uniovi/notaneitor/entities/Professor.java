package com.uniovi.notaneitor.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String category;

    public Professor(){}

    public Professor(String dni, String name, String surname, String category){
        this.surname = surname;
        this.dni = dni;
        this.name = name;
        this.category = category;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String apellidos) {
        this.surname = apellidos;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categoria) {
        this.category = categoria;
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Professor{ id = " + id +  ", dni='" + dni + '\''
                + ", nombre =" + name + ", apellidos = " + surname + ", categoria = " + category + '}';
    }
}
