package com.lge.lgelineauditapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClassItemChecklist {
    // Fields
    private int itemChecklistID;
    private String secao;
    private String item;
    private String detalhe;
    private String especificacao;
    private String linha;
    private int peso;

    // constructors
    public ClassItemChecklist() {}

    public ClassItemChecklist(int itemChecklistID, String secao, String item, String detalhe, String especificacao, String linha, int peso) {
        this.itemChecklistID = itemChecklistID;
        this.secao = secao;
        this.item = item;
        this.detalhe = detalhe;
        this.especificacao = especificacao;
        this.linha = linha;
        this.peso = peso;
    }

    //properties
    public void setID(int id) {
        this.itemChecklistID = id;
    }
    public int getID() {
        return this.itemChecklistID;
    }

    public void setSecao(String secao){
        this.secao = secao;
    }
    public String getSecao() {
        return this.secao;
    }

    public void setItem(String item){
        this.item = item;
    }
    public String getItem() {
        return this.item;
    }

    public void setDetalhe(String detalhe){
        this.detalhe = detalhe;
    }
    public String getDetalhe() {
        return this.detalhe;
    }

    public void setEspecificacao(String especificacao){
        this.especificacao = especificacao;
    }
    public String getEspecificacao() {
        return this.especificacao;
    }

    public void setLinha(String linha){
        this.linha = linha;
    }
    public String getLinha() {
        return this.linha;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }
    public int getPeso() {
        return this.peso;
    }
}
