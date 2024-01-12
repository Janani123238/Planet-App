package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.planeto.databinding.ViewBinding

class Adapter(private var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
        val planetImg: ImageView = binding.planetImg
        val galaxy: TextView = binding.galaxy
        val distance: TextView = binding.distance
        val gravity: TextView = binding.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dummyImage: Int? = null

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetail::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = "${planet[position].distance} m km"
        holder.gravity.text = "${planet[position].gravity} m/ss"

        dummyImage = when (planet[position].title?.toLowerCase()) {
            "mars" -> R.drawable.mars
            "neptune" -> R.drawable.neptune
            "earth" -> R.drawable.earth
            "moon" -> R.drawable.moon
            "venus" -> R.drawable.venus
            "jupiter" -> R.drawable.jupiter
            "saturn" -> R.drawable.saturn
            "uranus" -> R.drawable.uranus
            "mercury" -> R.drawable.mercury
            "sun" -> R.drawable.sun
            else -> null
        }

        dummyImage?.let {
            holder.planetImg.setImageResource(it)
        }
    }

    override fun getItemCount(): Int {
        return planet.size
    }
}



