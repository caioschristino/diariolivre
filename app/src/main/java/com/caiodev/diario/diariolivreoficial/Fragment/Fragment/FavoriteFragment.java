package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Persistence.Controller.History;
import com.caiodev.diario.diariolivreoficial.R;

import java.util.List;

/**
 * Created by CaioSChristino on 14/10/16.
 */

public class FavoriteFragment extends Fragment {
    private History history;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        history = new History(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        if (view != null) {
            List<Doc> docs = history.getAll();
            Log.e("-->", docs.toString());
        }
        return view;
    }

    MyReceiver r;
    public void refresh() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(r);
    }

    public void onResume() {
        super.onResume();
        r = new MyReceiver();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(r,
                new IntentFilter("TAG_REFRESH"));
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            FavoriteFragment.this.refresh();
        }
    }
}
