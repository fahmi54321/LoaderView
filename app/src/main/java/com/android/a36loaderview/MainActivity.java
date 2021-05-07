package com.android.a36loaderview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.elyeproj.loaderviewlibrary.LoaderImageView;
import com.elyeproj.loaderviewlibrary.LoaderTextView;

public class MainActivity extends AppCompatActivity {

    LoadDataHelper loadDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();

        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    private void reset() {
        ((LoaderTextView) findViewById(R.id.txtName)).resetLoader();
        ((LoaderTextView) findViewById(R.id.txtTitle)).resetLoader();
        ((LoaderImageView) findViewById(R.id.image_icon)).resetLoader();

        ((LoaderTextView) findViewById(R.id.txtName1)).resetLoader();
        ((LoaderTextView) findViewById(R.id.txtTitle1)).resetLoader();
        ((LoaderImageView) findViewById(R.id.image_icon1)).resetLoader();

        loadData();
    }

    private void loadData() {
        if (loadDataHelper !=null){
            loadDataHelper.cancel(true);
        }
        loadDataHelper = new LoadDataHelper();
        loadDataHelper.execute();
    }

    private class LoadDataHelper extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setData();
        }
    }

    private void setData() {
        ((TextView) findViewById(R.id.txtName)).setText("Danny");
        ((TextView) findViewById(R.id.txtTitle)).setText("Fighter");
        ((ImageView) findViewById(R.id.image_icon)).setImageResource(R.drawable.danny);

        ((TextView) findViewById(R.id.txtName1)).setText("Wu");
        ((TextView) findViewById(R.id.txtTitle1)).setText("Actor");
        ((ImageView) findViewById(R.id.image_icon1)).setImageResource(R.drawable.wu);
    }
}