package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Swipe to delete functionality
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(getCatData())
    }

    private fun getCatData(): List<CatModel> {
        return listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Fred",
                "Silent and deadly",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Wilma",
                "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.ExoticShorthair,
                "Tom",
                "Professional napper",
                "https://cdn2.thecatapi.com/images/9u1.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BalineseJavanese,
                "Luna",
                "Moonlight hunter",
                "https://cdn2.thecatapi.com/images/bti.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Simba",
                "Future king of the house",
                "https://cdn2.thecatapi.com/images/d5q.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Misty",
                "Mysterious wanderer",
                "https://cdn2.thecatapi.com/images/6s9.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Oscar",
                "Gourmet food critic",
                "https://cdn2.thecatapi.com/images/3k8.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.AmericanCurl,
                "Bella",
                "Elegant and graceful",
                "https://cdn2.thecatapi.com/images/4r2.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.ExoticShorthair,
                "Shadow",
                "Master of stealth",
                "https://cdn2.thecatapi.com/images/1p7.jpg"
            ),

            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Charlie",
                "Adventure seeker",
                "https://cdn2.thecatapi.com/images/5f6.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Daisy",
                "Flower lover",
                "https://cdn2.thecatapi.com/images/8h3.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Max",
                "Speed runner",
                "https://cdn2.thecatapi.com/images/2k4.jpg"
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}