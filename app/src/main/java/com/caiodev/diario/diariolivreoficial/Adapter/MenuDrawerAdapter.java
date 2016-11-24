package com.caiodev.diario.diariolivreoficial.Adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.caiodev.diario.diariolivreoficial.Model.Facet;
import com.caiodev.diario.diariolivreoficial.R;

/**
 * Created by CaioSChristino on 23/11/16.
 */
public class MenuDrawerAdapter extends ArrayAdapter<Facet> {
    Context context;
    List<Facet> drawerItemList;
    int layoutResID;

    public MenuDrawerAdapter(Context context, int layoutResourceID, List<Facet> listItems) {
        super(context, layoutResourceID, listItems);
        this.context = context;
        this.drawerItemList = listItems;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FacetHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            drawerHolder = new FacetHolder();

            view = inflater.inflate(layoutResID, parent, false);
            drawerHolder.ItemName = (TextView) view.findViewById(R.id.drawer_itemName);
            drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);

            view.setTag(drawerHolder);

        } else {
            drawerHolder = (FacetHolder) view.getTag();
        }

        Facet dItem = (Facet) this.drawerItemList.get(position);
        drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_manage));
        drawerHolder.ItemName.setText(dItem.getName());
        return view;
    }

    private static class FacetHolder {
        TextView ItemName;
        ImageView icon;
    }
}