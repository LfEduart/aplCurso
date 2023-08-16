/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author Usuario
 */
public class Veiculo {
    private int idVeiculo;
    private String marcaveiculo;
    private String modeloveiculo;
    private Modelo idModelo;
    private Marca idMarca;

    public Veiculo() {
        this.idVeiculo = 0;
        this.marcaveiculo = "";
        this.modeloveiculo = "";
        this.idModelo = new Modelo();
        this.idMarca = new Marca();
    }

    public Veiculo(int idVeiculo, String marcaveiculo, String modeloveiculo, Modelo idModelo, Marca idMarca) {
        this.idVeiculo = idVeiculo;
        this.marcaveiculo = marcaveiculo;
        this.modeloveiculo = modeloveiculo;
        this.idModelo = idModelo;
        this.idMarca = idMarca;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarcaveiculo() {
        return marcaveiculo;
    }

    public void setMarcaveiculo(String marcaveiculo) {
        this.marcaveiculo = marcaveiculo;
    }

    public String getModeloveiculo() {
        return modeloveiculo;
    }

    public void setModeloveiculo(String modeloveiculo) {
        this.modeloveiculo = modeloveiculo;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }
}
