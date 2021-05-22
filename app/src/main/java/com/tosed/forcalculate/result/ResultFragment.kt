package com.tosed.forcalculate.result

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.tosed.forcalculate.R
import com.tosed.forcalculate.databinding.FragmentResultBinding
import com.tosed.forcalculate.sharedView.SharedViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("StringFormatMatches", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)

        sharedViewModel.imc.observe(viewLifecycleOwner, { newIMC ->
            binding.tvResultadoPeso.text = "Seu IMC é: %.2f".format(newIMC)
        })

        sharedViewModel.ranking.observe(viewLifecycleOwner, { newRanking ->
            binding.tvRank.text = "Classificação: $newRanking"
        })

        /*arguments?.let {
          val args = ResultFragmentArgs.fromBundle(it)
            Log.d("IMC", args.imc.toString())

            val resultado = args.imc
            val modelo = when { // cria um toast na tela onde é mostrado qual é a sua classificação
                resultado < 18.5 -> "Peso baixo"
                resultado in 18.5..24.9 -> "Peso Normal"
                resultado in 25.0..29.9 -> "Sobrepeso"
                resultado in 30.0..34.9-> "Obesidade (Grau I)"
                resultado in 35.0..39.9 -> "Obesidade Severa (Grau II)"
                resultado > 40.0 -> "Obesidade Mórbida (Grau III)"
                else -> "Por favor, Preencha novamente"
            }
            binding.tvResultadoPeso.text = "Seu IMC é: %.2f".format(resultado) + "\n\nClassificação: $modelo"
        }*/

        return binding.root
    }

}