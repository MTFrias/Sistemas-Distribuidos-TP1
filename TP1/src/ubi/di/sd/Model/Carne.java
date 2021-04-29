package ubi.di.sd.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Carne extends Produto implements Serializable {

    public Carne(int _stock, double _precoCompra, double _precoVenda, LocalDateTime _validade, int _quantidadeMinima) {
        super(_stock,_precoCompra,_precoVenda,_validade,_quantidadeMinima);

    }


}
