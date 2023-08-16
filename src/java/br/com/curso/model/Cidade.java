/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author Usuario
 */
public class Cidade {
    private int idCidade;
    private String nomecidade;
    private String situacao;
    private Estado estado;

    public Cidade() {
        this.idCidade = 0;
        this.nomecidade = "";
        this.situacao = "A";
        this.estado = new Estado();
    }

    public Cidade(int idCidade, String nomecidade, String situacao, Estado estado) {
        this.idCidade = idCidade;
        this.nomecidade = nomecidade;
        this.situacao = situacao;
        this.estado = estado;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
