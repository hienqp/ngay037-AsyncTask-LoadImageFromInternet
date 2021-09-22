package com.hienqp.loadimagefrominternet;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageFromInternetAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private Activity activity;
    private Bitmap bitmapImage;
    private ImageView imageView;

    public LoadImageFromInternetAsyncTask(Activity activity, ImageView imageViewDisplayImage) {
        this.activity = activity;
        this.imageView = imageViewDisplayImage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);

            InputStream inputStream = url.openConnection().getInputStream();

            bitmapImage = BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmapImage;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageView.setImageBitmap(bitmap);
    }
}
