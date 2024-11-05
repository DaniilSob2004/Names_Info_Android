package com.example.namesfragment_hw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.namesfragment_hw.model.NameModel;

import java.util.List;

public class NameAdapter extends ArrayAdapter<NameModel> {

    private LayoutInflater inflater;
    private int layout;
    private List<NameModel> nameModels;

    public NameAdapter(Context context, int resources, List<NameModel> nameModels) {
        super(context, resources, nameModels);

        this.inflater = LayoutInflater.from(context);
        this.layout = resources;
        this.nameModels = nameModels;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = this.inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NameModel nameModel = nameModels.get(position);
        viewHolder.nameView.setText(nameModel.getName());

        return convertView;
    }

    private class ViewHolder {

        final TextView nameView;

        ViewHolder(View view) {
            nameView = view.findViewById(R.id.name_text_view);
        }
    }
}
