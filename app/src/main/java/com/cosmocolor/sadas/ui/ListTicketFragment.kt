package com.cosmocolor.sadas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cosmocolor.sadas.R
import com.cosmocolor.sadas.adapter.TicketAdapter
import com.cosmocolor.sadas.databinding.FragmentListTicketBinding
import com.cosmocolor.sadas.model.Ticket
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class ListTicketFragment : Fragment(), TicketAdapter.OnItemClickListener {

    lateinit var binding: FragmentListTicketBinding

    val pendingTickets = listOf<Ticket>(
        Ticket(
            "INC-2022-09111",
            "LICENCIAS ESTADO DE MÉXICO",
            "ATIZAPÁN DE ZARAGOZA TARJETAS",
            "SECRETARÍA DE MOVILIDAD DEL ESTADO DE MÉXICO",
            "15-03-2022 11:15 A.M."
        ),
        Ticket(
            "INC-2022-09918",
            "ISSEMYM",
            "U. ATT. DRCHAB. ECATEPEC",
            "INSTITUTO DE SEGURODAD SOCIAL DEL ESTADO DE MÉXICO Y MUNICIPIO",
            "22-03-2022 13:05 P.M."
        ),
        Ticket(
            "INC-2022-09918",
            "ISSEMYM",
            "U. ATT. DRCHAB. ECATEPEC",
            "INSTITUTO DE SEGURODAD SOCIAL DEL ESTADO DE MÉXICO Y MUNICIPIO",
            "22-03-2022 13:05 P.M."
        ), Ticket(
            "INC-2022-09918",
            "ISSEMYM",
            "U. ATT. DRCHAB. ECATEPEC",
            "INSTITUTO DE SEGURODAD SOCIAL DEL ESTADO DE MÉXICO Y MUNICIPIO",
            "22-03-2022 13:05 P.M."
        ),
        Ticket(
            "INC-2022-09918",
            "ISSEMYM",
            "U. ATT. DRCHAB. ECATEPEC",
            "INSTITUTO DE SEGURODAD SOCIAL DEL ESTADO DE MÉXICO Y MUNICIPIO",
            "22-03-2022 13:05 P.M."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildUI()
    }

    private fun buildUI() {
        buildReciclerView()
    }

    private fun buildReciclerView() {
        binding.rvTicketList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTicketList.adapter = TicketAdapter(pendingTickets, this)
    }

    fun onItemSelected(ticket: Ticket) {
        Toast.makeText(requireContext(), ticket.id, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(ticket: Ticket) {
        val action = ListTicketFragmentDirections.actionListTicketFragmentToDetailActivity(ticket)
        findNavController().navigate(action)
    }


}