package com.dicoding.topstadion

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.topstadion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        fun getLayoutResourceId(): Int {
            return R.layout.activity_detail
        }
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvStadion: RecyclerView
    private lateinit var listStadionAdapter: ListStadionAdapter
    private val list = ArrayList<Stadion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvStadion = findViewById(R.id.rv_stadi)
        rvStadion.setHasFixedSize(true)
        rvStadion.layoutManager =LinearLayoutManager(this)


        list.addAll(getListStadion())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvStadion.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_list -> {
                rvStadion.layoutManager = GridLayoutManager(this,2)

            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListStadion(): ArrayList<Stadion>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listStadion = ArrayList<Stadion>()
        for (i in dataName.indices) {
            val stadion = Stadion(dataName[i],dataDescription[i],dataPhoto.getResourceId(i, -1))
            listStadion.add(stadion)
        }
        dataPhoto.recycle()
        return listStadion
    }

    private fun showRecyclerList() {
        rvStadion.layoutManager = LinearLayoutManager(this)
        val listStadionAdapter = ListStadionAdapter(list)
        rvStadion.adapter = listStadionAdapter
    }
}