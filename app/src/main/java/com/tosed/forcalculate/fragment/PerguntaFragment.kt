package com.tosed.forcalculate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.tosed.forcalculate.databinding.FragmentPerguntaBinding


class PerguntaFragment : Fragment(), Communicator {

    lateinit var binding: FragmentPerguntaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pergunta, container, false)
        binding.btnCalcular.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_perguntaFragment_to_resultFragment)
        }
        return binding.root
    }

    /*private fun setListeners() {
        val pesoEDT =  binding.pesoEDT.text.toString()
        val alturaEDT = binding.alturaEDT.text.toString()

        if(pesoEDT.isEmpty() || alturaEDT.isEmpty()){ // verifica se os valores é vazios
            Toast.makeText(context, "Campos vazios, Por Favor preencha corretamente", Toast.LENGTH_SHORT).show()
        }
        return calcularIMC(pesoEDT, alturaEDT)
    }

    private fun calcularIMC(peso: String, altura: String){
        val pesoEDT = peso.toFloatOrNull()
        val alturaEDT = altura.toFloatOrNull()

        if(pesoEDT != null && alturaEDT != null){
            val imc = pesoEDT / (alturaEDT * alturaEDT)

            when{ // cria um toast na tela onde é mostrado qual é a sua classificação
                imc < 18.5 -> Toast.makeText(context, "Peso Baixo", Toast.LENGTH_SHORT).show()
                imc in 18.5..24.9 -> Toast.makeText(context, "Peso Normal", Toast.LENGTH_SHORT).show()
                imc in 25.0..29.9 -> Toast.makeText(context, "Sobrepeso", Toast.LENGTH_SHORT).show()
                imc in 30.0..34.9-> Toast.makeText(context, "Obesidade (Grau I)", Toast.LENGTH_SHORT).show()
                imc in 35.0..39.9 -> Toast.makeText(context, "Obesidade Severa (Grau II)", Toast.LENGTH_SHORT).show()
                imc > 40.0 -> Toast.makeText(context, "Obesidade Mórbida (Grau III)", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(context, "Por favor, Preencha novamente", Toast.LENGTH_SHORT).show()
            }
        }
    }*/

    override fun passDataClass(imc: String) {
        val bundle = Bundle()
        bundle.putString("message", imc)
    }

}