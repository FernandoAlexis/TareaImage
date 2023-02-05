package com.android.tareaimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnLink;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLink = findViewById(R.id.btnSitio);
        url="https://es.wikipedia.org/wiki/El_Se%C3%B1or_de_los_Anillos";

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.imagen, ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/seed/picsum/200/300",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/200/300?grayscale",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/id/870/200/300?grayscale&blur=2",ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);

    }
}