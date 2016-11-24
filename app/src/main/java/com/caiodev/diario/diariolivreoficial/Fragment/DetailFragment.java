package com.caiodev.diario.diariolivreoficial.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.R;
import com.caiodev.diario.diariolivreoficial.SessionManager;

/**
 * Created by CaioSChristino on 24/11/16.
 */

public class DetailFragment extends Fragment {
    private Doc doc;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doc = ((SessionManager) getActivity().getApplicationContext()).getSessionDoc();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        if (view != null) {
            if (doc != null) {
                ((TextView) view.findViewById(R.id.txTitle)).setText(doc.getTexto());
            }
        }
        return view;
    }
}