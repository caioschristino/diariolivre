package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.caiodev.diario.diariolivreoficial.Adapter.IAdapterOnClickListener;
import com.caiodev.diario.diariolivreoficial.Adapter.RecycleAdapter;
import com.caiodev.diario.diariolivreoficial.Fragment.DetailFragment;
import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Persistence.Controller.History;
import com.caiodev.diario.diariolivreoficial.R;
import com.caiodev.diario.diariolivreoficial.SessionManager;

import java.util.List;

/**
 * Created by CaioSChristino on 14/10/16.
 */

public class FavoriteFragment extends Fragment implements FavoriteView {
    private FavoritePresenter presenter;
    private View view;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecycleAdapter adapter;
    private History history;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        history = new History(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new FavoritePresenterImpl(this);
        view = inflater.inflate(R.layout.fragment_recycle_adapter, container, false);
        if (view != null) {
            progressBar = (ProgressBar) view.findViewById(R.id.progress);
            adapter = new RecycleAdapter();
            if (adapter != null) {
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
            presenter.onResume(getContext());
        }
        return view;
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<Doc> docs) {
        adapter.dataSetAdapterChanged(docs, new IAdapterOnClickListener() {
            @Override
            public void onShareItem(Doc doc) {

            }

            @Override
            public void onLikeItem(Doc doc) {
                history.add(doc);
                adapter.notifySaveClick();
            }

            @Override
            public boolean isFavorite(String id) {
                return history.exist(id);
            }

            @Override
            public void onClickItem(Doc doc) {
                ((SessionManager) getActivity().getApplicationContext()).setSessionDoc(doc);

                Fragment fragment = new DetailFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerView, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void showMessage(String message) {

    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            FavoriteFragment.this.refresh();
        }
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
}
