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

class ArticleAdapter(
    val context: HomeActivity,
    private val cvList: List<CvModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleImage = view.findViewById<ImageView>(R.id.image_item)
        val articleName:TextView? = view.findViewById(R.id.name_item)
        val articleDescription:TextView? = view.findViewById(R.id.description_item)

        companion object {
            val articleNameKey = "ARTICLE_NAME"
            val articleImageKey = "ARTICLE_IMAGE"
            val articleDescriptionKey = "ARTICLE_DESCRIPTION"
        }
        init {
            view.setOnClickListener{
                val intent = Intent(view.context, CvDetailsActivity::class.java)
                intent.putExtra(articleImageKey, articleImage.toString())
                intent.putExtra(articleDescriptionKey, articleDescription?.text)
                intent.putExtra(articleNameKey, articleName?.text)
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
        val currentArticle = cvList[position]

        // recuperer le repository
        val repo = CvRepository()

        // utiliser glide pour recuperer l'image à partir de son lien -> composant
        Glide.with(context).load(Uri.parse(currentArticle.imageUrl)).into(holder.articleImage)

        // mettre à jour le nom du cv
        holder.articleName?.text = currentArticle.name

        // mettre à jour la description du cv
        holder.articleDescription?.text = currentArticle.description

/*        // mettre à jour l'image (intent extra)
        holder.articleImage?.drawable */

        // mettre à jour l'objet cv
        repo.updateCV(currentArticle)
    }

    override fun getItemCount(): Int = cvList.size
}