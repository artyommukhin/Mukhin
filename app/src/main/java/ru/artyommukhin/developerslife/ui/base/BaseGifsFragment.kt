package ru.artyommukhin.developerslife.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.artyommukhin.developerslife.databinding.FragmentViewGifsBinding


abstract class BaseGifsFragment<VM: BaseViewModel>: Fragment() {

    abstract fun getViewModel() : Class<VM>

    private var _binding: FragmentViewGifsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[getViewModel()]

        _binding = FragmentViewGifsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.loadNext()

        binding.btnPrev.setOnClickListener { viewModel.loadPrev() }
        binding.btnNext.setOnClickListener { viewModel.loadNext() }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}