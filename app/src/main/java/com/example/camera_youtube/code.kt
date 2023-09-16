package com.example.camera_youtube

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class code : AppCompatActivity() {
//    private var btn_picture: Button? = null
    private var iamgeview: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iamgeview = findViewById(R.id.imageview)
        var btn_picture : Button = findViewById(R.id.btn_picture)
        btn_picture.setOnClickListener{
            View.OnClickListener { takePicture() }
        }
    }

    fun takePicture() {
        val imageIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (imageIntent.resolveActivity(packageManager) != null) {
            registerForActivityResult(imageIntent, REQUEST_IMAGE_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CODE && resultCode == RESULT_OK) {
            val extras = data!!.extras
            val imageBitmap = extras!!["data"] as Bitmap?
            iamgeview!!.setImageBitmap(imageBitmap)
        }
    }

    companion object {
        private const val REQUEST_IMAGE_CODE = 101
    }
}