package com.caiodev.diario.diariolivreoficial.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by CaioSChristino on 07/10/16.
 */

@DatabaseTable
public class Doc {
    public static final String ID = "id";

    @DatabaseField(id = true, generatedId = false)
    private String id;
    @DatabaseField
    private Date data;
    @DatabaseField
    private String retranca;
    @DatabaseField
    private String tipo_conteudo;
    @DatabaseField
    private String secretaria;
    @DatabaseField
    private String orgao;
    @DatabaseField
    private String texto;
    @DatabaseField
    private boolean favorito;

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

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
