package com.tosed.forcalculate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.alturaEDT
import kotlinx.android.synthetic.main.activity_main.calcularBTN
import kotlinx.android.synthetic.main.activity_main.pesoEDT
import kotlinx.android.synthetic.main.activity_tela_bmi.*

class tela_bmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_bmi)
        setListeners()

        supportActionBar?.title = "Calculadora BMI"
    }

    private fun setListeners(){
        calcularBTN.setOnClickListener {
            val pesoEDT = pesoEDT.text.toString()
            val alturaEDT = alturaEDT.text.toString()

            if(pesoEDT.isEmpty() && alturaEDT.isEmpty()){
                Toast.makeText(this, "Campos vazios, Por Favor preencha corretamente", Toast.LENGTH_SHORT).show()
            }else {
                calcularBMI(pesoEDT.toString(), alturaEDT.toString())
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularBMI(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val calculoAltura = (altura * altura)
            val bmiFinal = peso / calculoAltura
            result.text = "Seu BMI: %.2f".format(bmiFinal)

            when{ // cria um toast na tela onde é mostrado qual é a sua classificação
                bmiFinal < 18.5 -> dica.text = "Peso Baixo"
                bmiFinal in 18.5..24.9 -> dica.text = "Peso Normal"
                bmiFinal in 25.0..29.9 -> dica.text = "Peso Baixo"
                bmiFinal in 30.0..34.9-> dica.text = "Obesidade (Grau I)"
                bmiFinal in 35.0..39.9 -> dica.text = "Obesidade Severa (Grau II)"
                bmiFinal > 40.0 -> dica.text = "Obesidade Mórbida (Grau III)"
                else -> dica.text = "Por favor, Preencha novamente"
            }
        }
    }
}