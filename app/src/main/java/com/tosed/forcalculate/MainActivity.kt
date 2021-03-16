package com.tosed.forcalculate
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

        supportActionBar?.title = "Calculadora IMC"

        val context = this
        bmiBTN.setOnClickListener {
            val intent = Intent(context, tela_bmi::class.java)
            startActivity(intent)
        }
    }

    private fun setListeners(){
        calcularBTN?.setOnClickListener {
            val pesoEDT =  pesoEDT.text.toString()
            val alturaEDT = alturaEDT.text.toString()

            if(pesoEDT.isEmpty() && alturaEDT.isEmpty()){ // verifica se os valores é vazios
                Toast.makeText(this, "Campos vazios, Por Favor preencha corretamente", Toast.LENGTH_SHORT).show()
            }

            else{
                calcularIMC(pesoEDT.toString(), alturaEDT.toString())
            }

        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val imc = peso / (altura * altura)
            titleTXT.text = "Seu IMC:\n %.2f".format(imc)


            when{ // cria um toast na tela onde é mostrado qual é a sua classificação
                imc < 18.5 -> Toast.makeText(this, "Peso Baixo", Toast.LENGTH_SHORT).show()
                imc in 18.5..24.9 -> Toast.makeText(this, "Peso Normal", Toast.LENGTH_SHORT).show()
                imc in 25.0..29.9 -> Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show()
                imc in 30.0..34.9-> Toast.makeText(this, "Obesidade (Grau I)", Toast.LENGTH_SHORT).show()
                imc in 35.0..39.9 -> Toast.makeText(this, "Obesidade Severa (Grau II)", Toast.LENGTH_SHORT).show()
                imc > 40.0 -> Toast.makeText(this, "Obesidade Mórbida (Grau III)", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Por favor, Preencha novamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

