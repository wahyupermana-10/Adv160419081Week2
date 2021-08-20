package com.ubaya.adv160419081week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart.setOnClickListener {
            val playerName = txtName.text
            if (playerName.toString() == "")
                Toast.makeText(context, "Input Nama Anda Belum di Isi", Toast.LENGTH_SHORT).show()
            else {
                val action = MainFragmentDirections.actionGameFragment(playerName.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}