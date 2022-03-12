package com.gdsc.sogongsogong.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.lang.IllegalStateException

open class BaseFragment<VDB: ViewDataBinding>(private val layoutId: Int): Fragment() {

    private var _binding: VDB? = null
    val binding get() = _binding ?: throw IllegalStateException(ERROR_BINDING_INITIALIZE)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ERROR_BINDING_INITIALIZE = "binding initialize error"
    }
}