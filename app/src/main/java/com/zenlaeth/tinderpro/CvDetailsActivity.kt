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
        val textCvDescription: TextView = findViewById(R.id.cv_detail_description)
        val textCvName: TextView = findViewById(R.id.cv_detail_name)
        val textCvExperience: TextView = findViewById(R.id.cv_detail_experience)
        val textCvLevelStudies: TextView = findViewById(R.id.cv_detail_level_studies)

        val bundle: Bundle? = intent.extras
        val cvImageId = bundle!!.getInt(CvAdapter.ViewHolder.cvImageKey)
        val cvDescription = intent.getStringExtra(CvAdapter.ViewHolder.cvDescriptionKey)
        val cvName = intent.getStringExtra(CvAdapter.ViewHolder.cvNameKey)
        val cvExperience = intent.getStringExtra(CvAdapter.ViewHolder.cvExperienceKey)
        val cvLevelStudies = intent.getStringExtra(CvAdapter.ViewHolder.cvLevelStudiesKey)

        imageView.setImageResource(cvImageId)
        textCvDescription.text = cvDescription
        textCvName.text = cvName
        textCvExperience.text = cvExperience
        textCvLevelStudies.text = cvLevelStudies
        /*val cvImageItem = findViewById<ImageView>(R.id.cv_image_item)
*/
    }
}