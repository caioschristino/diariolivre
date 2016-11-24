package com.caiodev.diario.diariolivreoficial.Fragment.Home;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.caiodev.diario.diariolivreoficial.Adapter.IAdapterOnClickListener;
import com.caiodev.diario.diariolivreoficial.Adapter.HomeRecycleAdapter;
import com.caiodev.diario.diariolivreoficial.Fragment.DetailFragment;
import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.Persistence.Controller.History;
import com.caiodev.diario.diariolivreoficial.R;
import com.caiodev.diario.diariolivreoficial.SessionManager;

/**
 * Created by CaioSChristino on 14/10/16.
 */

public class HomeFragment extends Fragment implements HomeView {
    private HomePresenter presenter;
    private View view;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HomeRecycleAdapter adapter;
    private History history;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        history = new History(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new HomePresenterImpl(this);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        if (view != null) {
            progressBar = (ProgressBar) view.findViewById(R.id.progress);
            adapter = new HomeRecycleAdapter();
            if (adapter != null) {
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume(getActivity().getApplicationContext());
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(Response response) {
        adapter.dataSetAdapterChanged(response.getDocs(), new IAdapterOnClickListener() {
            @Override
            public void onShareItem(Doc doc) {

            }

            @Override
            public void onLikeItem(Doc doc) {
                history.add(doc);
                adapter.notifySaveClick(doc);
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
}
