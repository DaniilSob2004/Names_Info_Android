package com.example.namesfragment_hw.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.namesfragment_hw.R;
import com.example.namesfragment_hw.model.NameModel;
import com.example.namesfragment_hw.utils.AppConstant;

public class NameDetailFragment extends Fragment {

    private NameModel nameModel;


    public static NameDetailFragment newInstance(NameModel nameModel) {
        NameDetailFragment fragment = new NameDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(AppConstant.ARG_NAME_MODEL, nameModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nameModel = getArguments().getParcelable(AppConstant.ARG_NAME_MODEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_detail, container, false);

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView datesTextView = view.findViewById(R.id.datesTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        if (nameModel != null) {
            nameTextView.setText(nameModel.getName());
            datesTextView.setText(nameModel.getDates());
            descriptionTextView.setText(nameModel.getDescription());
        }

        return view;
    }
}