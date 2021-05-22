package com.tosed.forcalculate.sharedView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _imc = MutableLiveData<Float>()
    val imc: LiveData<Float> = _imc

    private val _ranking =  MutableLiveData<String>()
    val ranking: LiveData<String> = _ranking


    fun calculate(height: String, weight: String){
        val peso = weight.toFloat()
        val altura = height.toFloat()
        _imc.value = ( peso / (altura * altura) )
        onRank(imc.value!!)
    }

    private fun onRank(onImc: Float){
        val types = when { // cria um toast na tela onde é mostrado qual é a sua classificação
            onImc < 18.5 -> "Peso baixo"
            onImc in 18.5..24.9 -> "Peso Normal"
            onImc in 25.0..29.9 -> "Sobrepeso"
            onImc in 30.0..34.9-> "Obesidade (Grau I)"
            onImc in 35.0..39.9 -> "Obesidade Severa (Grau II)"
            onImc > 40.0 -> "Obesidade Mórbida (Grau III)"
            else -> "Por favor, Preencha novamente"
        }
        _ranking.value = types
    }
}