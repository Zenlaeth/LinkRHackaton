package com.zenlaeth.tinderpro.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zenlaeth.tinderpro.*

class CvAdapter(
    val context: HomeActivity,
    private val cvList: List<CvModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<CvAdapter.ViewHolder>(){

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val cvImage = view.findViewById<ImageView>(R.id.image_item)
        val cvName:TextView? = view.findViewById(R.id.name_item)
        val cvDescription:TextView? = view.findViewById(R.id.description_item)

        companion object {
            val cvNameKey = "ARTICLE_NAME"
            val cvImageKey = "ARTICLE_IMAGE"
            val cvDescriptionKey = "ARTICLE_DESCRIPTION"
        }
        init {
            view.setOnClickListener{
                val intent = Intent(view.context, CvDetailsActivity::class.java)
                intent.putExtra(cvImageKey, cvImage.toString())
                intent.putExtra(cvDescriptionKey, cvDescription?.text)
                intent.putExtra(cvNameKey, cvName?.text)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les informations du cv
        val currentCv = cvList[position]

        // recuperer le repository
        val repo = CvRepository()

        // utiliser glide pour recuperer l'image à partir de son lien -> composant
        Glide.with(context).load(Uri.parse(currentCv.imageUrl)).into(holder.cvImage)

        // mettre à jour le nom du cv
        holder.cvName?.text = currentCv.name

        // mettre à jour la description du cv
        holder.cvDescription?.text = currentCv.description

/*        // mettre à jour l'image (intent extra)
        holder.cvImage?.drawable */

        // mettre à jour l'objet cv
        repo.updateCV(currentCv)
    }

    override fun getItemCount(): Int = cvList.size
}