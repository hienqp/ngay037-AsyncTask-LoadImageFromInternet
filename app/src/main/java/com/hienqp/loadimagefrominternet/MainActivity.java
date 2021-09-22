package com.hienqp.loadimagefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button buttonLoadImage;
    ImageView imageViewDisplayImage;
    String url = "https://kenh14cdn.com/thumb_w/640/pr/2021/1615871991234-23-0-431-653-crop-1615872000798-63751495502707.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        captureObjectViewFromLayout();

        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImageFromInternetAsyncTask(MainActivity.this, imageViewDisplayImage).execute(url);
            }
        });
    }

    private void captureObjectViewFromLayout() {
        buttonLoadImage = (Button) findViewById(R.id.button_load_image);
        imageViewDisplayImage = (ImageView) findViewById(R.id.imageView_display_image);
    }
}