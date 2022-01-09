package com.example.p071project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.*
import android.content.res.Resources
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    var radioAnimal: RadioButton? = null
    var radioPlant: RadioButton? = null
    var mainPhoto: ImageView? = null
    var name1: TextView? = null
    var describe: TextView? = null
    private var checked: Boolean = true
    var res: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioAnimal = findViewById(R.id.animal)
        radioPlant = findViewById(R.id.plant)
        mainPhoto = findViewById(R.id.mainPhoto)
        name1 = findViewById(R.id.name)
        describe = findViewById(R.id.describe)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setValues(image:Int,name:String,describe1:String) {
        mainPhoto!!.setImageResource(image)
        name1!!.text = name
        describe!!.text = describe1
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.vorobei -> setValues(
                R.drawable.vorobei,
                resources.getString(R.string.vorobei),
                resources.getString(R.string.vorobeiDescribe)
            )
            R.id.ivolga -> setValues(
                R.drawable.ivolga,
                resources.getString(R.string.ivolga),
                resources.getString(R.string.ivolgaDescribe)
            )
            R.id.soroka -> setValues(
                R.drawable.soroka,
                resources.getString(R.string.soroka),
                resources.getString(R.string.sorokaDescribe)
            )
            R.id.cow -> setValues(
                R.drawable.cow,
                resources.getString(R.string.cow),
                resources.getString(R.string.cowDescribe)
            )
            R.id.mouse -> setValues(
                R.drawable.mouse,
                resources.getString(R.string.mouse),
                resources.getString(R.string.mouseDescribe)
            )
            R.id.wolf -> setValues(
                R.drawable.wolf,
                resources.getString(R.string.wolf),
                resources.getString(R.string.wolfDescribe)
            )
            R.id.korop -> setValues(
                R.drawable.korop,
                resources.getString(R.string.korop),
                resources.getString(R.string.koropDescribe)
            )
            R.id.okunb -> setValues(
                R.drawable.okunb,
                resources.getString(R.string.okunb),
                resources.getString(R.string.okunbDescribe)
            )
            R.id.salar -> setValues(
                R.drawable.salar,
                resources.getString(R.string.salar),
                resources.getString(R.string.salarDescribe)
            )

            R.id.bambuk -> setValues(
                R.drawable.bambuk,
                resources.getString(R.string.bambuk),
                resources.getString(R.string.bambukDescribe)
            )
            R.id.vasilek -> setValues(
                R.drawable.vasilek,
                resources.getString(R.string.vasilek),
                resources.getString(R.string.vasilekDescribe)
            )
            R.id.oduvan -> setValues(
                R.drawable.oduvan,
                resources.getString(R.string.oduvan),
                resources.getString(R.string.oduvanDescribe)
            )
            R.id.klen -> setValues(
                R.drawable.klen,
                resources.getString(R.string.klen),
                resources.getString(R.string.klenDescribe)
            )
            R.id.dub -> setValues(
                R.drawable.dub,
                resources.getString(R.string.dub),
                resources.getString(R.string.dubDescribe)
            )
            R.id.sosna -> setValues(
                R.drawable.sosna,
                resources.getString(R.string.sosna),
                resources.getString(R.string.sosnaDescribe)
            )
            R.id.smorodina -> setValues(
                R.drawable.smorodina,
                resources.getString(R.string.smorodina),
                resources.getString(R.string.smorodinaDescribe)
            )
            R.id.malina -> setValues(
                R.drawable.malina,
                resources.getString(R.string.malina),
                resources.getString(R.string.malinaDescribe)
            )
            R.id.sirenb -> setValues(
                R.drawable.sirenb,
                resources.getString(R.string.sirenb),
                resources.getString(R.string.sirenbDescribe)
            )
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onCheckedRadio():Boolean {
        radioGroup!!.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.animal -> {
                    checked = true
                    setValues(
                        R.drawable.animals,
                        resources.getString(R.string.animals),
                        resources.getString(R.string.animalsDescribe)
                    )
                }
                R.id.plant -> {
                    checked = false
                    setValues(
                        R.drawable.plants,
                        resources.getString(R.string.plants),
                        resources.getString(R.string.plantsDescribe)
                    )
                }
            }
        }
        return checked
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (onCheckedRadio()){
            menu!!.setGroupVisible(R.id.groupOfAnimals, true)
            menu.setGroupVisible(R.id.groupOfPlants, false)
        }else if (!onCheckedRadio()){
            menu!!.setGroupVisible(R.id.groupOfAnimals, false)
            menu.setGroupVisible(R.id.groupOfPlants, true)
        }
        return super.onPrepareOptionsMenu(menu)

    }
}