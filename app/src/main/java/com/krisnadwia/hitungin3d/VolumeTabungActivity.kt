package com.krisnadwia.hitungin3d

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VolumeTabungActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editJari: EditText
    private lateinit var editTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnHapus: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_tabung)

        supportActionBar!!.title = "Tabung"

        editJari = findViewById(R.id.edit_text_volume_tabung_jari)
        editTinggi = findViewById(R.id.edit_text_volume_tabung_tinggi)
        btnHitung = findViewById(R.id.btn_hitung_volume_tabung_hasil)
        btnHapus = findViewById(R.id.btn_hapus_volume_tabung_hasil)
        tvHasil = findViewById(R.id.tv_hasil_volume_tabung)

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
        if (p0?.id == R.id.btn_hitung_volume_tabung_hasil) {
            val inputJari = editJari.text.toString().trim()
            val inputTinggi = editTinggi.text.toString().trim()

            var isEmptyFields = false

            if (inputJari.isEmpty()) {
                isEmptyFields = true
                editJari.error = "Field ini tidak boleh kosong!"
            }
            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                editTinggi.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyFields) {
                val volume =
                    kotlin.math.PI * inputJari.toDouble() * inputJari.toDouble() * inputTinggi.toDouble()
                tvHasil.text = volume.toString()
            }
        }

        if (p0?.id == R.id.btn_hapus_volume_tabung_hasil) {
            editJari.setText("")
            editTinggi.setText("")
            tvHasil.setText("Hasil")
        }
    }
}