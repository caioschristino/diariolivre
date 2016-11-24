package com.caiodev.diario.diariolivreoficial.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaioSChristino on 23/11/16.
 */

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.ViewHolder> {
    private List<Doc> values = new ArrayList<>();
    private IAdapterOnClickListener delegate;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    public void dataSetAdapterChanged(List<Doc> mItems, IAdapterOnClickListener mDelegate) {
        values = mItems;
        delegate = mDelegate;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Doc doc = values.get(position);
        holder.txTitle.setText(doc.getOrgao());
        holder.txContent.setText(String.format("Conteúdo: %s", doc.getTipo_conteudo()));
        holder.txSecretariat.setText(String.format("Secretária: %s", doc.getSecretaria()));
        holder.txDate.setText(android.text.format.DateFormat.format("dd/MM/yyyy", doc.getData()));

        holder.iVLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != delegate) {
                    delegate.onLikeItem(doc);
                }
            }
        });

        holder.iVShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != delegate) {
                    delegate.onShareItem(doc);
                }

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != delegate) {
                    delegate.onClickItem(doc);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void notifySaveClick(Doc doc) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txContent;
        public final TextView txTitle;
        public final TextView txSecretariat;
        public final TextView txDate;
        public final ImageView iVLike;
        public final ImageView iVShare;

        public ViewHolder(View view) {
            super(view);
            txTitle = (TextView) view.findViewById(R.id.txTitle);
            txContent = (TextView) view.findViewById(R.id.txContent);
            txSecretariat = (TextView) view.findViewById(R.id.txSecretariat);
            txDate = (TextView) view.findViewById(R.id.txDate);
            iVLike = (ImageView) view.findViewById(R.id.iVLike);
            iVShare = (ImageView) view.findViewById(R.id.iVShare);
        }
    }
}