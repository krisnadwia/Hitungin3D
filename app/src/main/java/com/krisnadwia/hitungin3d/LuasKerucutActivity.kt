package com.krisnadwia.hitungin3d

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LuasKerucutActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editJari: EditText
    private lateinit var editPelukis: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnHapus: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luas_kerucut)

        supportActionBar!!.title = "Kerucut"

        editJari = findViewById(R.id.edit_text_luas_kerucut_jari)
        editPelukis = findViewById(R.id.edit_text_luas_kerucut_pelukis)
        btnHitung = findViewById(R.id.btn_hitung_luas_kerucut_hasil)
        btnHapus = findViewById(R.id.btn_hapus_luas_kerucut_hasil)
        tvHasil = findViewById(R.id.tv_hasil_luas_kerucut)

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
        if (p0?.id == R.id.btn_hitung_luas_kerucut_hasil) {
            val inputJari = editJari.text.toString().trim()
            val inputPelukis = editPelukis.text.toString().trim()

            var isEmptyFields = false

            if (inputJari.isEmpty()) {
                isEmptyFields = true
                editJari.error = "Field ini tidak boleh kosong!"
            }
            if (inputPelukis.isEmpty()) {
                isEmptyFields = true
                editPelukis.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyFields) {
                val luas =
                    kotlin.math.PI * inputJari.toDouble() * (inputJari.toDouble() + inputPelukis.toDouble())
                tvHasil.text = luas.toString()
            }
        }

        if (p0?.id == R.id.btn_hapus_luas_kerucut_hasil) {
            editJari.setText("")
            editPelukis.setText("")
            tvHasil.setText("Hasil")
        }
    }
}