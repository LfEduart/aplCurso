/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author Usuario
 */
public class Modelo {
    private int idModelo;
    private String descricao;

    public Modelo() {
        this.idModelo = 0;
        this.descricao = "";
    }

    public Modelo(int idModelo, String descricao) {
        this.idModelo = idModelo;
        this.descricao = descricao;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
