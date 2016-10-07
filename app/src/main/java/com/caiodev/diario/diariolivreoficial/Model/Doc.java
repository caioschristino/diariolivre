package com.caiodev.diario.diariolivreoficial.Model;

import java.util.Date;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class Doc {
    private String id;
    private Date data;
    private String retranca;
    private String tipo_conteudo;
    private String secretaria;
    private String orgao;
    private String texto;

    public String getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getRetranca() {
        return retranca;
    }

    public String getTipo_conteudo() {
        return tipo_conteudo;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public String getOrgao() {
        return orgao;
    }

    public String getTexto() {
        return texto;
    }
}
