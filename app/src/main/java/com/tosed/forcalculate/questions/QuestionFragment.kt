package com.tosed.forcalculate.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.tosed.forcalculate.R
import com.tosed.forcalculate.databinding.FragmentPerguntaBinding
import com.tosed.forcalculate.sharedView.SharedViewModel


class QuestionFragment : Fragment() {

    private lateinit var binding: FragmentPerguntaBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pergunta, container, false)

        binding.btnCalcular.setOnClickListener {
            setListeners()
        }

       sharedViewModel.imc.observe(viewLifecycleOwner, { newIMC ->
           resultFinished()
       })
        return binding.root
    }

    private fun setListeners() {
        val weightEDT =  binding.pesoEDT.text.toString()
        val heightEDT = binding.alturaEDT.text.toString()

        if(weightEDT.isEmpty() || heightEDT.isEmpty()){ // verifica se os valores é vazios
            Toast.makeText(context, "Campos vazios, Por Favor preencha corretamente!", Toast.LENGTH_SHORT).show()
        } else {
            sharedViewModel.calculate(height = heightEDT, weight = weightEDT)
        }
    }
    private fun resultFinished(){
        val action = QuestionFragmentDirections.actionPerguntaFragmentToResultFragment()
        view?.findNavController()?.navigate(action)
    }
}

