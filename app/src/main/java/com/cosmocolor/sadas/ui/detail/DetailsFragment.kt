package com.cosmocolor.sadas.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cosmocolor.sadas.R
import com.cosmocolor.sadas.databinding.FragmentDetailsBinding
import com.cosmocolor.sadas.model.Ticket
import com.cosmocolor.sadas.util.Constanst.TICKET_BUNDLE

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    val arg = arguments
    val ticketBundle: Ticket? = arg?.getParcelable(TICKET_BUNDLE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}