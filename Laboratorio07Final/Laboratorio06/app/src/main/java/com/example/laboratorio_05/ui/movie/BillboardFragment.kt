package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.databinding.FragmentBillboardBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BillboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var buttonFirstFragment: CardView
    private lateinit var buttonFirsThreeFragment: CardView
    private lateinit var binding: FragmentBillboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bin()
        buttonFirstFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        buttonFirsThreeFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_threeFragment)
        }


    }

    fun bin(){
        buttonFirstFragment=view?.findViewById(R.id.new_movie_button) as CardView
        buttonFirsThreeFragment=view?.findViewById(R.id.one_card) as CardView
    }

}