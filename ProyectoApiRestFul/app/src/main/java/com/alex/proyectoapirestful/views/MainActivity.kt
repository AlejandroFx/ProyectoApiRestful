package com.alex.proyectoapirestful.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.adapters.PokemonAdapter
import com.alex.proyectoapirestful.R
import com.alex.proyectoapirestful.models.pokemon.PokemonView
import com.alex.proyectoapirestful.viewModels.MainActivityViewModel
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String){
    Glide.with(view.context)
        .load(url)
        .into(view)
}

class MainActivity : AppCompatActivity() {

    private lateinit var rbWater: RadioButton
    private lateinit var rbFire: RadioButton
    private lateinit var rbFlying: RadioButton
    private lateinit var rbGround: RadioButton
    private lateinit var rbBug: RadioButton
    private lateinit var rbGosth: RadioButton
    private lateinit var rbGrass: RadioButton
    private lateinit var rbDragon: RadioButton
    private lateinit var rbPoison: RadioButton
    var tipo: String =""

    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbWater= findViewById<RadioButton>(R.id.rbWater)
        rbFire= findViewById<RadioButton>(R.id.rbFire)
        rbFlying= findViewById<RadioButton>(R.id.rbFlying)
        rbGround= findViewById<RadioButton>(R.id.rbGround)
        rbBug= findViewById<RadioButton>(R.id.rbBug)
        rbGosth= findViewById<RadioButton>(R.id.rbGosth)
        rbGrass= findViewById<RadioButton>(R.id.rbGrass)
        rbDragon= findViewById<RadioButton>(R.id.rbDragon)
        rbPoison= findViewById<RadioButton>(R.id.rbPoison)

        rbWater.setOnCheckedChangeListener(changeChecked)
        rbFire.setOnCheckedChangeListener(changeChecked)
        rbFlying.setOnCheckedChangeListener(changeChecked)
        rbGround.setOnCheckedChangeListener(changeChecked)
        rbBug.setOnCheckedChangeListener(changeChecked)
        rbGosth.setOnCheckedChangeListener(changeChecked)
        rbGrass.setOnCheckedChangeListener(changeChecked)
        rbDragon.setOnCheckedChangeListener(changeChecked)
        rbPoison.setOnCheckedChangeListener(changeChecked)




        mainActivityViewModel.pokemonListLiveData.observe(this,
            Observer<List<PokemonView>> {
                val recyclerView= findViewById<RecyclerView>(R.id.recyclerViewPokémon)
                val pokemonAdapter=
                    PokemonAdapter();
                recyclerView.layoutManager= LinearLayoutManager(this)
                recyclerView.adapter= pokemonAdapter
                pokemonAdapter.addResults(it)
                pokemonAdapter.notifyDataSetChanged()
            }
        )

    }
    private val changeChecked = CompoundButton.OnCheckedChangeListener { button, checked ->

        if(rbWater.isChecked ){
            tipo=rbWater.text.toString()

        }
        if(rbFire.isChecked ){
            tipo=rbFire.text.toString()

        }
        if(rbFlying.isChecked ){
            tipo=rbFlying.text.toString()

        }
        if(rbGround.isChecked ){
            tipo=rbGround.text.toString()

        }
        if(rbBug.isChecked ){
            tipo=rbBug.text.toString()

        }
        if(rbGosth.isChecked ){
            tipo=rbGosth.text.toString()

        }
        if(rbGrass.isChecked ){
            tipo=rbGrass.text.toString()

        }
        if(rbDragon.isChecked ){
            tipo=rbDragon.text.toString()

        }
        if(rbPoison.isChecked ){
            tipo=rbPoison.text.toString()

        }

        mainActivityViewModel.getType(tipo)


    }

}