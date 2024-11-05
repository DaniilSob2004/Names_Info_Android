package com.example.namesfragment_hw.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.namesfragment_hw.NameAdapter;
import com.example.namesfragment_hw.R;
import com.example.namesfragment_hw.model.NameModel;
import com.example.namesfragment_hw.utils.TaskFactory;

import java.util.List;

public class NameListFragment extends Fragment {

    private NameAdapter nameAdapter;
    private List<NameModel> nameModels;
    private GridView nameListGridView;


    private OnDataSendListener dataSendListener;

    public interface OnDataSendListener {
        void onSendData(NameModel nameModel);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDataSendListener) {
            dataSendListener = (OnDataSendListener) context;
        }
        else {
            throw new RuntimeException(context + " must implement OnDataSendListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // создание коллекции имён
        nameModels = TaskFactory.getNameModels();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_list, container, false);

        // настройка адаптера коллекции имён
        setNameAdapter(view);

        return view;
    }


    private void setNameAdapter(View view) {
        // получаем элемент GridView
        nameListGridView = view.findViewById(R.id.name_list_grid_view);

        // создаём адаптер
        nameAdapter = new NameAdapter(getContext(), R.layout.name_item, nameModels);

        // устанавливаем адаптер в список
        nameListGridView.setAdapter(nameAdapter);

        // установка обработчика по клику
        nameListGridView.setOnItemClickListener((parent, view1, position, id) -> {
            NameModel selectedName = nameModels.get(position);
            if (dataSendListener != null) {
                dataSendListener.onSendData(selectedName);
            }
        });
    }
}