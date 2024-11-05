package com.example.namesfragment_hw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.namesfragment_hw.R;
import com.example.namesfragment_hw.fragments.NameDetailFragment;
import com.example.namesfragment_hw.fragments.NameListFragment;
import com.example.namesfragment_hw.model.NameModel;

public class MainActivity extends AppCompatActivity implements NameListFragment.OnDataSendListener {

    private ImageButton btnImgToolbar;
    private TextView titleToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // инициализация
        init();

        // начальная установка фрагмента со списком имён
        if (savedInstanceState == null) {
            openNameListFragment();
        }
    }

    @Override
    public void onSendData(NameModel nameModel) {
        openDetailFragment(nameModel);
    }


    public void clickBack(View view) {
        btnImgToolbar.setImageResource(R.drawable.names);
        titleToolbar.setText(getString(R.string.name_list));
        openNameListFragment();
    }


    private void init() {
        btnImgToolbar = findViewById(R.id.btn_img_toolbar);
        titleToolbar = findViewById(R.id.title_toolbar);
    }

    private void setContFragment(Fragment frg) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, frg)
                .addToBackStack(null)
                .commit();
    }

    private void openNameListFragment() {
        Fragment nameListFrg = new NameListFragment();
        setContFragment(nameListFrg);
    }

    private void openDetailFragment(NameModel nameModel) {
        btnImgToolbar.setImageResource(R.drawable.back);
        titleToolbar.setText(getString(R.string.name_details));

        NameDetailFragment detailFragment = NameDetailFragment.newInstance(nameModel);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}