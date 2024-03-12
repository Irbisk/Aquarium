package org.hyperskill.aquarium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.hyperskill.aquarium.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageAnimals = intent.extras?.get("imageAnimals") ?: listOf(R.drawable.image1)
        val nameAnimals = intent.extras?.get("nameAnimals") ?: listOf("Koi Carp")
        val descriptionAnimals = intent.extras?.get("descriptionAnimals") ?: listOf(
            "These colorful, ornamental fish are a variety of the Amur carp. " +
                    "They were originally found in Central Europe and Asia, " +
                    "but they’ve spread to many other parts of the world. " +
                    "Koi carp are popular with breeders, and there are currently over 100 varieties " +
                    "created through breeding.\n" +
                    "\n" +
                    "The average age of a koi carp can vary based on the part of the world it’s bred in. " +
                    "Carps bred outside of Japan have an average lifespan of around 15 years," +
                    " while carps bred in Japan can live 40 years or more. The oldest koi carp on record," +
                    " which was a fish named Hanako, reportedly lived for 226 years!"
        )

        binding.imageView.setImageResource((imageAnimals as List<Int>)[0])
        binding.tvName.text = (nameAnimals as List<String>)[0]
        binding.tvDescription.text = (descriptionAnimals as List<String>)[0]
    }
}
