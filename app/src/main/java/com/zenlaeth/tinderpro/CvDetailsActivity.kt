package com.zenlaeth.tinderpro

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zenlaeth.tinderpro.adapter.CvAdapter

class CvDetailsActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cv_details)

        /*val image = intent.getStringExtra(CvAdapter.ViewHolder.cvImageKey)*/
        val imageView: ImageView = findViewById(R.id.cv_image_item)
        val textView: TextView = findViewById(R.id.cv_detail_description)
        val textView2: TextView = findViewById(R.id.cv_detail_name)

        val bundle: Bundle? = intent.extras
        val cvImageId = bundle!!.getInt(CvAdapter.ViewHolder.cvImageKey)
        val cvDescription = intent.getStringExtra(CvAdapter.ViewHolder.cvDescriptionKey)
        val cvName = intent.getStringExtra(CvAdapter.ViewHolder.cvNameKey)

        imageView.setImageResource(cvImageId)
        textView.text = cvDescription
        textView2.text = cvName
        /*val cvImageItem = findViewById<ImageView>(R.id.cv_image_item)
*/
    }
}