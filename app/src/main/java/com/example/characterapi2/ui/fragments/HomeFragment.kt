package com.example.characterapi2.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.character.R
import com.example.character.databinding.FragmentHomeBinding
import com.example.characterapi2.base.BaseFragment
import com.example.characterapi2.ui.adapters.HomeAdapter
import com.example.characterapi2.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()

    override fun initialize() {
        binding.rvHome.adapter = homeAdapter
    }

    override fun setupSubscribes() {
        subscribeToGetData()
    }

    private fun subscribeToGetData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    homeAdapter.submitList(it.data)
                }
            }
        }
    }
}