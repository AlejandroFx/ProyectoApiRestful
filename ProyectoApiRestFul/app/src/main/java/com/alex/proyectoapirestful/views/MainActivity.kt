package com.alex.proyectoapirestful.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

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
    private lateinit var rbDragon: RadioButton
    val tipos = arrayOf<String>("ghost","fairy","electric","steel", "dark")
    val tipos2= arrayOf<String>("water","fire","flying","ground","dragon")
    var tipo :String =""
    var cont=0

    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbWater= findViewById<RadioButton>(R.id.rbWater)
        rbFire= findViewById<RadioButton>(R.id.rbFire)
        rbFlying= findViewById<RadioButton>(R.id.rbFlying)
        rbGround= findViewById<RadioButton>(R.id.rbGround)
        rbDragon= findViewById<RadioButton>(R.id.rbDragon)


        rbWater.setOnCheckedChangeListener(changeChecked)
        rbFire.setOnCheckedChangeListener(changeChecked)
        rbFlying.setOnCheckedChangeListener(changeChecked)
        rbGround.setOnCheckedChangeListener(changeChecked)
        rbDragon.setOnCheckedChangeListener(changeChecked)


       val botonAleatorio= findViewById<Button>(R.id.buttonAleatorio)
        buttonAleatorio.setOnClickListener {

            if(rbWater.text=="water"){
                rbWater.text=tipos[0]
                rbFire.text=tipos[1]
                rbFlying.text=tipos[2]
                rbGround.text=tipos[3]
                rbDragon.text=tipos[4]

                rbWater.isChecked=false
                rbFire.isChecked=false
                rbFlying.isChecked=false
                rbGround.isChecked=false
                rbDragon.isChecked=false
            }else{
                if(rbWater.text=="ghost"){
                    rbWater.text=tipos2[0]
                    rbFire.text=tipos2[1]
                    rbFlying.text=tipos2[2]
                    rbGround.text=tipos2[3]
                    rbDragon.text=tipos2[4]

                    rbWater.isChecked=false
                    rbFire.isChecked=false
                    rbFlying.isChecked=false
                    rbGround.isChecked=false
                    rbDragon.isChecked=false
                }
            }



        }



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
            if(rbGround.isChecked){
                rbGround.isChecked=false;
            }

            if( rbDragon.isChecked){
                rbDragon.isChecked=false;
            }


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

        if(rbDragon.isChecked ){
            tipo=rbDragon.text.toString()


        }

        mainActivityViewModel.getType(tipo)


    }


}