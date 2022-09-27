package com.wiryadev.tabwithpagersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.wiryadev.tabwithpagersample.databinding.FragmentChatsBinding


class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getInt(TITLE_ARG)

        title?.let {
            binding.textView.text = "Fragment ${context?.getString(it)}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TITLE_ARG = "chat_fragment_title_arg"

        fun newInstance(title: Int) = ChatsFragment().apply {
            arguments = bundleOf(
                TITLE_ARG to title
            )
        }
    }
}