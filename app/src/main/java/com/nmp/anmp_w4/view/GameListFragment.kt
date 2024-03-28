package com.nmp.anmp_w4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nmp.anmp_w4.R
import com.nmp.anmp_w4.databinding.FragmentGameListBinding
import com.nmp.anmp_w4.model.DetailViewModel
import com.nmp.anmp_w4.model.ListViewModel

class GameListFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentGameListBinding
    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.fetch()

        viewModel.studentID.observe(viewLifecycleOwner, Observer { Game ->
        })

    }

}