package com.example.p10project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val adapter = TeamAdapter()
    private val imageIdList = listOf(
        R.drawable.anaheim,
        R.drawable.arizona,
        R.drawable.boston,
        R.drawable.buffalo,
    R.drawable.calgary,
    R.drawable.carolina,
    R.drawable.chicago,
    R.drawable.colorado,
    R.drawable.columbus,
    R.drawable.dallas,
    R.drawable.detroit,
    R.drawable.edmonton,
    R.drawable.florida,
    R.drawable.los_angeles,
    R.drawable.minnesota,
    R.drawable.montreal,
    R.drawable.nashville,
    R.drawable.new_islanders,
    R.drawable.new_jersey,
    R.drawable.new_rangers,
    R.drawable.ottawa,
    R.drawable.philadelphia,
    R.drawable.pittsburgh,
    R.drawable.san_jose,
    R.drawable.seattle,R.drawable.st_louis,
    R.drawable.tampa,
    R.drawable.toronto,
    R.drawable.vancouver,
    R.drawable.vegas,R.drawable.washington,
    R.drawable.winnipeg)

    private val teamNameList = listOf<String>("Anaheim Ducks","Arizona Coyotes","Boston Bruins","Buffalo Sabres","Calgary Flames","Carolina Hurricanes",
        "Chicago Blackhawks","Colorado Avalanche","Columbus Blue Jackets","Dallas Stars",
        "Detroit Red Wings","Edmonton Oilers","Florida Panthers","Los Angeles Kings","Minnesota Wild",
        "Montreal Canadiens","Nashville Predators","New Jersey Devils","New York Islanders","New York Rangers",
        "Ottawa Senators","Philadelphia Flyers","Pittsburgh Penguins","San Jose Sharks","Seattle Kraken",
        "St Louis Blues","Tampa Bay Lightning","Toronto Maple Leafs","Vancouver Canucks",
        "Vegas Golden Knights","Washington Capitals","Winnipeg Jets")

    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        val buttonAdd:Button = findViewById(R.id.buttonAdd)


         fun init(){
            rcView.layoutManager = GridLayoutManager(this,3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index >imageIdList.size-1) index = 0
                val team = Team(imageIdList[index],teamNameList[index])
                adapter.addTeam(team)
                index++
            }

        }
        init()
    }






}
