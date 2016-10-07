package com.caiodev.diario.diariolivreoficial.Model;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class Response {
    private List<Doc> docs;
    private List<Facet> facets;
    private Pages pages;

    public List<Doc> getDocs() {
        return docs;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public Pages getPages() {
        return pages;
    }
}
