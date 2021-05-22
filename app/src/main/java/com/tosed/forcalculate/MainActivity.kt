package com.tosed.forcalculate
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tosed.forcalculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setListeners()

    }

   /* private fun setListeners(){
        calcularBTN?.setOnClickListener {
            val pesoEDT =  binding.pesoEDT.text.toString()
            val alturaEDT = binding.alturaEDT.text.toString()

            if(pesoEDT.isEmpty() && alturaEDT.isEmpty()){ // verifica se os valores é vaziosuntil
                Toast.makeText(this, "Campos vazios, Por Favor preencha corretamente", Toast.LENGTH_SHORT).show()
            }

            else{
                calcularIMC(pesoEDT, alturaEDT)
            }

        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val pesoEDT = peso.toFloatOrNull()
        val alturaEDT = altura.toFloatOrNull()

        if(pesoEDT != null && alturaEDT != null){
            val imc = pesoEDT / (alturaEDT * alturaEDT)
            binding.titleTXT.text = "Seu IMC:\n %.2f".format(imc)

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
    }*/
}

