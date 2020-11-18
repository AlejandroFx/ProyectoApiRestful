package com.alex.proyectoapirestful.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.adapters.PokemonAdapter
import com.alex.proyectoapirestful.R
import com.alex.proyectoapirestful.models.Pokemon.PokemonView
import com.alex.proyectoapirestful.viewModels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var checkWater: CheckBox
    private lateinit var checkFire: CheckBox
    private lateinit var checkGosth: CheckBox
    private lateinit var checkGrass: CheckBox
    private lateinit var checkPoison: CheckBox
    private lateinit var checkFlying: CheckBox
    private lateinit var checkGround: CheckBox
    private lateinit var checkElectric: CheckBox
    private lateinit var checkBug: CheckBox

    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView= findViewById<RecyclerView>(R.id.recyclerViewPokémon)
        val pokemonAdapter=
            PokemonAdapter();
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= pokemonAdapter

        checkWater = findViewById<CheckBox>(R.id.checkBoxWater)
        checkFire = findViewById<CheckBox>(R.id.checkBoxFire)
        checkGosth = findViewById<CheckBox>(R.id.checkBoxGosth)
        checkGrass = findViewById<CheckBox>(R.id.checkBoxGrass)
        checkPoison = findViewById<CheckBox>(R.id.checkBoxPoison)
        checkFlying = findViewById<CheckBox>(R.id.checkBoxFlying)
        checkGround = findViewById<CheckBox>(R.id.checkBoxGround)
        checkElectric = findViewById<CheckBox>(R.id.checkBoxElectric)
        checkBug = findViewById<CheckBox>(R.id.checkBoxBug)


        mainActivityViewModel.pokemonListLiveData.observe(this,
            Observer<List<PokemonView>> {
                pokemonAdapter.addResults(it)
                pokemonAdapter.notifyDataSetChanged()
            }
        )

    }
    private val changeChecked = CompoundButton.OnCheckedChangeListener { button, checked ->
        var tipo: String =""

        if(checkWater.isChecked ){
            tipo=checkWater.text.toString()

        }
        if(checkFire.isChecked ){
            tipo=checkFire.text.toString()

        }
        if(checkGosth.isChecked ){
            tipo=checkGosth.text.toString()

        }
        if(checkGrass.isChecked ){
            tipo=checkGrass.text.toString()

        }
        if(checkPoison.isChecked ){
            tipo=checkPoison.text.toString()

        }
        if(checkFlying.isChecked ){
            tipo=checkFlying.text.toString()

        }
        if(checkGround.isChecked ){
            tipo=checkGround.text.toString()

        }
        if(checkElectric.isChecked ){
            tipo=checkElectric.text.toString()

        }
        if(checkBug.isChecked ){
            tipo=checkBug.text.toString()

        }

        mainActivityViewModel.getPokemon()

    }
}