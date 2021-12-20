package com.krisnadwia.hitungin3d

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVolumeKubusActivity: Button = findViewById(R.id.btn_hitung_volume_kubus)
        btnVolumeKubusActivity.setOnClickListener(this)
        val btnLuasKubusActivity: Button = findViewById(R.id.btn_hitung_luas_kubus)
        btnLuasKubusActivity.setOnClickListener(this)
        val btnVolumeBalokActivity: Button = findViewById(R.id.btn_hitung_volume_balok)
        btnVolumeBalokActivity.setOnClickListener(this)
        val btnLuasBalokActivity: Button = findViewById(R.id.btn_hitung_luas_balok)
        btnLuasBalokActivity.setOnClickListener(this)
        val btnVolumeTabungActivity: Button = findViewById(R.id.btn_hitung_volume_tabung)
        btnVolumeTabungActivity.setOnClickListener(this)
        val btnLuasTabungActivity: Button = findViewById(R.id.btn_hitung_luas_tabung)
        btnLuasTabungActivity.setOnClickListener(this)
        val btnVolumeKerucutActivity: Button = findViewById(R.id.btn_hitung_volume_kerucut)
        btnVolumeKerucutActivity.setOnClickListener(this)
        val btnLuasKerucutActivity: Button = findViewById(R.id.btn_hitung_luas_kerucut)
        btnLuasKerucutActivity.setOnClickListener(this)
        val btnVolumeBolaActivity: Button = findViewById(R.id.btn_hitung_volume_bola)
        btnVolumeBolaActivity.setOnClickListener(this)
        val btnLuasBolaActivity: Button = findViewById(R.id.btn_hitung_luas_bola)
        btnLuasBolaActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_hitung_volume_kubus -> {
                val moveIntentVolumeKubus =
                    Intent(this@MainActivity, VolumeKubusActivity::class.java)
                startActivity(moveIntentVolumeKubus)
            }
            R.id.btn_hitung_luas_kubus -> {
                val moveIntentLuasKubus = Intent(this@MainActivity, LuasKubusActivity::class.java)
                startActivity(moveIntentLuasKubus)
            }
            R.id.btn_hitung_volume_balok -> {
                val moveIntentVolumeBalok =
                    Intent(this@MainActivity, VolumeBalokActivity::class.java)
                startActivity(moveIntentVolumeBalok)
            }
            R.id.btn_hitung_luas_balok -> {
                val moveIntentLuasBalok = Intent(this@MainActivity, LuasBalokActivity::class.java)
                startActivity(moveIntentLuasBalok)
            }
            R.id.btn_hitung_volume_tabung -> {
                val moveIntentVolumeTabung =
                    Intent(this@MainActivity, VolumeTabungActivity::class.java)
                startActivity(moveIntentVolumeTabung)
            }
            R.id.btn_hitung_luas_tabung -> {
                val moveIntentLuasTabung = Intent(this@MainActivity, LuasTabungActivity::class.java)
                startActivity(moveIntentLuasTabung)
            }
            R.id.btn_hitung_volume_kerucut -> {
                val moveIntentVolumeKerucut =
                    Intent(this@MainActivity, VolumeKerucutActivity::class.java)
                startActivity(moveIntentVolumeKerucut)
            }
            R.id.btn_hitung_luas_kerucut -> {
                val moveIntentLuasKerucut =
                    Intent(this@MainActivity, LuasKerucutActivity::class.java)
                startActivity(moveIntentLuasKerucut)
            }
            R.id.btn_hitung_volume_bola -> {
                val moveIntentVolumeBola = Intent(this@MainActivity, VolumeBolaActivity::class.java)
                startActivity(moveIntentVolumeBola)
            }
            R.id.btn_hitung_luas_bola -> {
                val moveIntentLuasBola = Intent(this@MainActivity, LuasBolaActivity::class.java)
                startActivity(moveIntentLuasBola)
            }
        }
    }

    // make menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // onclick menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    // what menu does when clicked
    private fun setMode(selectedMode: Int) {
        if (selectedMode == R.id.menu_about) {
            val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(aboutIntent)
        }
    }
}