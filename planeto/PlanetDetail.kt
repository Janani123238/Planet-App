package com.example.planeto



import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.planeto.databinding.DetailBinding

class PlanetDetail : AppCompatActivity() {
    private lateinit var obj: PlanetData
    private var planetImg: Int? = null
    private lateinit var binding: DetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        obj = intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage", -1)
        setData(obj, planetImg!!)

        binding.buttonInfo.setOnClickListener {
            val intent = Intent(this, finalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(obj: PlanetData, planetImg: Int) {
        binding.titleInfo.text = obj.title
        binding.distanceInfo.text = "${obj.distance}m km"
        binding.gravityInfo.text = "${obj.gravity} m/ss"
        binding.overviewInfo.text = obj.overview
        binding.galaxyInfo.text = obj.galaxy
        binding.planetImgInfo.setImageResource(planetImg)
    }
}



