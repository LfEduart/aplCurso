/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author Usuario
 */
public class Imovel {
    private int idImovel;
    private String descricaoimovel;
    private String valorimovel;

    public Imovel() {
        this.idImovel = 0;
        this.descricaoimovel = "";
        this.valorimovel = "";
    }

    public Imovel(int idImovel, String descricaoimovel, String valorimovel) {
        this.idImovel = idImovel;
        this.descricaoimovel = descricaoimovel;
        this.valorimovel = valorimovel;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getDescricaoimovel() {
        return descricaoimovel;
    }

    public void setDescricaoimovel(String descricaoimovel) {
        this.descricaoimovel = descricaoimovel;
    }

    public String getValorimovel() {
        return valorimovel;
    }

    public void setValorimovel(String valorimovel) {
        this.valorimovel = valorimovel;
    }
    
}
