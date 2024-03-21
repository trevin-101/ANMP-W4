package com.nmp.anmp_w4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nmp.anmp_w4.R
import com.nmp.anmp_w4.databinding.FragmentStudentDetailBinding
import com.nmp.anmp_w4.model.DetailViewModel
import com.nmp.anmp_w4.model.ListViewModel


class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding
    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.fetch()

        viewModel.studentID.observe(viewLifecycleOwner, Observer { student ->
            binding.txtId1.setText(student.id)
            binding.txtName1.setText(student.name)
            binding.txtBirth1.setText(student.dob)
            binding.txtPhone1.setText(student.phone)
        })

        binding.btnUpdate.setOnClickListener {
            listViewModel.updateData()
        }
    }
}