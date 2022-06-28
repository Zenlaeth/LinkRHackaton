package com.zenlaeth.tinderpro

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zenlaeth.tinderpro.adapter.ArticleAdapter

class CvDetailsActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cv_details)

        /*val image = intent.getStringExtra(ArticleAdapter.ViewHolder.articleImageKey)*/
        val imageView: ImageView = findViewById(R.id.article_image_item)
        val textView: TextView = findViewById(R.id.article_detail_description)
        val textView2: TextView = findViewById(R.id.article_detail_name)

        val bundle: Bundle? = intent.extras
        val articleImageId = bundle!!.getInt(ArticleAdapter.ViewHolder.articleImageKey)
        val articleDescription = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDescriptionKey)
        val articleName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleNameKey)

        imageView.setImageResource(articleImageId)
        textView.text = articleDescription
        textView2.text = articleName
        /*val articleImageItem = findViewById<ImageView>(R.id.article_image_item)
*/
    }
}