package com.example.prueba_laboratorio_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var buttonFirstFragment: Button
    private lateinit var buttonFirsThreeFragment: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bin()
        buttonFirstFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment2_to_secondFragment2)
        }
        buttonFirsThreeFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment2_to_threeFragment)
        }
    }

    fun bin(){
        buttonFirstFragment=view?.findViewById(R.id.new_movie_button) as Button
        buttonFirsThreeFragment=view?.findViewById(R.id.one_card)as CardView
    }

}