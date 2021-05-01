package ubi.di.sd.Model;

import java.io.Serializable;

public class MensagemFornecedor implements Serializable {
    private String Mensgem;
    private String NomeForncedor;

    public MensagemFornecedor(String mensgem, String nomeForncedor) {
        Mensgem = mensgem;
        NomeForncedor = nomeForncedor;
    }

    public String getMensgem() {
        return Mensgem;
    }

    public void setMensgem(String mensgem) {
        Mensgem = mensgem;
    }

    public String getNomeForncedor() {
        return NomeForncedor;
    }

    public void setNomeForncedor(String nomeForncedor) {
        NomeForncedor = nomeForncedor;
    }

    @Override
    public String toString() {
        return "MensagemFornecedor{" +
                "Mensgem='" + Mensgem + '\'' +
                ", NomeForncedor='" + NomeForncedor + '\'' +
                '}';
    }
}
