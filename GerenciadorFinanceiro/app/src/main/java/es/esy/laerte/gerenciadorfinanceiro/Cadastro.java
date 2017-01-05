package es.esy.laerte.gerenciadorfinanceiro;

import java.io.Serializable;

/**
 * Created by Laerte on 21/12/2016.
 */

public class Cadastro implements Serializable{
    private String nome;
    private String valor;
    private String dataVenc;
    private String tipo;
    private String status;

    public Cadastro() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }

    @Override
    public String toString() {
        
        return " Nome: " +nome+
                "\n Valor R$: "+valor+
                "\n Data de Vencimento: "+dataVenc+
                "\n Status : "+status+
                "\n Tipo: "+tipo;
    }
}
