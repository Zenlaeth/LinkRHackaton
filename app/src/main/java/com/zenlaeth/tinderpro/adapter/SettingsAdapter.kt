package com.zenlaeth.tinderpro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.tinderpro.R

class SettingsAdapter(private var mListener: onItemClickListener): RecyclerView.Adapter<SettingsAdapter.ViewHolder>() {
    val titles = arrayOf("Profile","Address")
    val images = arrayOf(R.drawable.ic_profile, R.drawable.ic_address)

/*    private lateinit var mListener : onItemClickListener*/

    interface onItemClickListener {
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.settings_list_item, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.settingsTitle.text = titles[i]
        viewHolder.settingsImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var settingsImage: ImageView
        var settingsTitle: TextView

        init {
            settingsImage = itemView.findViewById(R.id.settings_image)
            settingsTitle = itemView.findViewById(R.id.settings_title)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}