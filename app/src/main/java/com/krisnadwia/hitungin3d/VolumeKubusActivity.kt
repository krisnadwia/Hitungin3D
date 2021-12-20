package com.krisnadwia.hitungin3d

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VolumeKubusActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editSisi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnHapus: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_kubus)

        supportActionBar!!.title = "Kubus"

        editSisi = findViewById(R.id.edit_text_volume_kubus_sisi)
        btnHitung = findViewById(R.id.btn_hitung_volume_kubus_hasil)
        btnHapus = findViewById(R.id.btn_hapus_volume_kubus_hasil)
        tvHasil = findViewById(R.id.tv_hasil_volume_kubus)

        btnHitung.setOnClickListener(this)
        btnHapus.setOnClickListener(this)

        if (savedInstanceState != null) {
            val hasil = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = hasil
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_hitung_volume_kubus_hasil) {
            val inputSisi = editSisi.text.toString().trim()

            var isEmptyFields = false

            if (inputSisi.isEmpty()) {
                isEmptyFields = true
                editSisi.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyFields) {
                val volume = inputSisi.toDouble() * inputSisi.toDouble() * inputSisi.toDouble()
                tvHasil.text = volume.toString()
            }
        }

        if (p0?.id == R.id.btn_hapus_volume_kubus_hasil) {
            editSisi.setText("")
            tvHasil.setText("Hasil")
        }
    }
}