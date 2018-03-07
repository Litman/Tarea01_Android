package com.itcgroup.vector.takephotoexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private final String TAG_PHOTO = "Take_Photo";

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    Button btTakePhoto;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTakePhoto = findViewById(R.id.btTakePhoto);
        imgView = findViewById(R.id.ivPhoto);

        btTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePhotoIntent.resolveActivity(getPackageManager()) != null ){
                    startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);

        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_PHOTO, "Enter onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_PHOTO, "Enter onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_PHOTO, "Enter onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_PHOTO, "Enter onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_PHOTO, "Enter onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_PHOTO, "Enter onDestroy");
    }
}
