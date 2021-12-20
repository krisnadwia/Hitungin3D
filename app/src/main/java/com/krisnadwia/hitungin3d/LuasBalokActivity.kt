package com.krisnadwia.hitungin3d

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LuasBalokActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editPanjang: EditText
    private lateinit var editLebar: EditText
    private lateinit var editTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var btnHapus: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luas_balok)

        supportActionBar!!.title = "Balok"

        editPanjang = findViewById(R.id.edit_text_luas_balok_panjang)
        editLebar = findViewById(R.id.edit_text_luas_balok_lebar)
        editTinggi = findViewById(R.id.edit_text_luas_balok_tinggi)
        btnHitung = findViewById(R.id.btn_hitung_luas_balok_hasil)
        btnHapus = findViewById(R.id.btn_hapus_luas_balok_hasil)
        tvHasil = findViewById(R.id.tv_hasil_luas_balok)

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
        if (p0?.id == R.id.btn_hitung_luas_balok_hasil) {
            val inputPanjang = editPanjang.text.toString().trim()
            val inputLebar = editLebar.text.toString().trim()
            val inputTinggi = editTinggi.text.toString().trim()

            var isEmptyFields = false

            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                editPanjang.error = "Field ini tidak boleh kosong!"
            }
            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                editLebar.error = "Field ini tidak boleh kosong!"
            }
            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                editTinggi.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyFields) {
                val luas =
                    2 * (inputPanjang.toDouble() * inputLebar.toDouble() + inputPanjang.toDouble() * inputTinggi.toDouble() + inputLebar.toDouble() * inputTinggi.toDouble())
                tvHasil.text = luas.toString()
            }
        }

        if (p0?.id == R.id.btn_hapus_luas_balok_hasil) {
            editPanjang.setText("")
            editLebar.setText("")
            editTinggi.setText("")
            tvHasil.setText("Hasil")
        }
    }
}