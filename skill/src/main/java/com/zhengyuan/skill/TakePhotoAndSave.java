package com.zhengyuan.skill;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.net.URI;

/**
 * Created by Administrator on 2018/10/8.
 */

public class TakePhotoAndSave extends Activity implements View.OnClickListener {
    public ImageView takePhotoImageView;
    public static final int REQUST_TAKE_PHOTTO_CODE2 = 2;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_takephotoandsave);

        initView();
        initEvent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.takePhotoImageView:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageToGallery.filePath);
                /*ContentValues values = new ContentValues();
                intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values));
*/
                startActivityForResult(intent, 2);
                break;
        }
    }

    private void initView() {
        takePhotoImageView = (ImageView) findViewById(R.id.takePhotoImageView);
    }

    private void initEvent() {
        takePhotoImageView.setOnClickListener(this);
    }



   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUST_TAKE_PHOTTO_CODE2 && resultCode == Activity.RESULT_OK) {
            //Toast.makeText(TakePhotoAndSave.this,"RESULT_OK",Toast.LENGTH_SHORT).show();
            //拍照结果处理
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Bitmap bm = (Bitmap) bundle.get("data");
                if (bm != null) {
                    ImageToGallery.saveImageToGallery(getApplicationContext(), bm);
                    Toast.makeText(TakePhotoAndSave.this, "ImageToGallery2", Toast.LENGTH_LONG).show();
                    //takePhotoImageView.setImageBitmap(bm);
                    Log.i("test001", ImageToGallery.filePath);

                    Glide.with(this).load(ImageToGallery.filePath).asBitmap().into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                            //图片加载完成
                            takePhotoImageView.setImageBitmap(bitmap);
                            Log.i("test001", ImageToGallery.filePath);
                        }
                    });

                }
            } else {
                //Toast.makeText(Carout_details.this, "没有压缩的图片数据", Toast.LENGTH_LONG).show();
            }
        }
    }*/

}
