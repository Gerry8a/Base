package com.cosmocolor.sadas.ui.detail.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cosmocolor.sadas.R
import com.cosmocolor.sadas.databinding.FragmentDetailsBinding
import com.cosmocolor.sadas.model.Ticket
import com.cosmocolor.sadas.ui.detail.IncidentViewModel
import com.cosmocolor.sadas.util.Constanst.TICKET_BUNDLE

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    val arg = arguments
    private val ticketBundle: Ticket? = arg?.getParcelable("ggg")
    private val incidentViewModel: IncidentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        Log.d("ggg", ticketBundle!!.id.toString())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fgFechaSolicitud.text = ticketBundle?.fechaSolicitud
        binding.fgProblema.text = ticketBundle?.problema
        binding.fgDescripcion.text = ticketBundle?.descripcionProblema
        binding.fgProyecto.text = ticketBundle?.nombreProyecto
        binding.fgUnidadOperativa.text = ticketBundle?.unidadOperativa
        binding.fgAreaCliente.text = ticketBundle?.areaCliente
        binding.fgTipoIncidente.text = ticketBundle?.tipoIncidente
//        if (ticketBundle!!.operando) {
//            binding.ivCheckbox.setImageResource(R.drawable.ic_checkbox_on)
//        } else {
//            binding.ivCheckbox.setImageResource(R.drawable.ic_checkbox_off)
//        }
    }
}