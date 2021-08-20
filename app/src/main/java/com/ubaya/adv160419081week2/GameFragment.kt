package com.ubaya.adv160419081week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*


class GameFragment : Fragment() {

    var score = 0
//    var jawaban = txtAnswer.text.toString().toInt()
    var hasil = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    public fun addition() {
        var num1 = (0..10).random()
        var num2 = (0..10).random()
        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()

        hasil = num1 + num2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addition()
        if(arguments != null) {
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        btnAnswer.setOnClickListener {
            if (txtAnswer.text.toString() == "")
                Toast.makeText(context, "Input Jawaban Anda Kosong", Toast.LENGTH_SHORT).show()
            else {
                if (txtAnswer.text.toString().toInt() == hasil){
                    addition()
                    txtAnswer.setText("")
                    score++
                }
                else {
                    val action = GameFragmentDirections.actionResultFragment(score)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
}