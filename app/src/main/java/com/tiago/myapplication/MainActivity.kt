package com.tiago.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tiago.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.button_calcular) {
                calcular()
            }
        }
    }

    private fun validacao(): Boolean {
        return (binding.editTextKmDistancia.text.toString() != ""
                && binding.editTextPrecoPorLitro.text.toString() != ""
                && binding.editTextAutonomia.text.toString() != "")
    }

    private fun calcular() {
        if (validacao()) {
            val distancia = binding.editTextKmDistancia.text.toString().toFloat()
            val preco = binding.editTextPrecoPorLitro.text.toString().toFloat()
            val autonomia = binding.editTextAutonomia.text.toString().toFloat()
            val totalDoValor = (distancia * preco) / autonomia

            binding.textValor.text = "R$ ${"%.2f".format(totalDoValor)}"
        }else{
            Toast.makeText(this, "Informações inválidas! Preencha os campos", Toast.LENGTH_LONG).show()
        }
    }
}