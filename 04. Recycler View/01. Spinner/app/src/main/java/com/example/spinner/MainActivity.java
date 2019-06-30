package com.example.spinner;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.spinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setUpSpinner();
        setUpRecView();
    }

    private void setUpRecView() {
        GalleryAdapter adapter = new GalleryAdapter(getClickListener());
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
    }

    private GalleryItemViewHolder.GalleryItemListener getClickListener() {
        return new GalleryItemViewHolder.GalleryItemListener() {
            @Override
            public void onGalleryItemClicked(ImageItem item) {
                Toast.makeText(MainActivity.this, "Gallery item clicked : " + item.description, Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setUpSpinner() {
        String[] spinnerItems = new String[] {
                "One", "Two", "Three"
        };

        // Create an ArrayAdapter, add items and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerItems);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        binding.spinner.setAdapter(adapter);
    }
}
