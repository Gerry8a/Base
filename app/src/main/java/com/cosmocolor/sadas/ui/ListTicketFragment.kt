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
            "Incidente",
            "15-03-2022 11:15 A.M.",
            "Desconfiguración de terminal de cobro (error please enter password",
            "Operador reporta desconfiguración de terminal de cobro Roberto de la Cruz Martinez contacto 5579091873 correo toxiatzipan@cosmocolor.com.mx Boulevard Adolfo López Mateos S/N, Puerta B-106 colonia el potrero, atizapan de zaragoza, estado de México. CP. 52975",
            true,
            "Gobierno de estado de México",
            "Roberto De la Cruz Martinez",
            "5579091873",
            "Perosnal Operativo Cliente",
            "NA",
            false
        ),
        Ticket(
            "INC-2022-10367",
            "Licencias Estado de México",
            "Texcoco",
            "Secretaría de movilidad del Estado de México",
            "Incidente",
            "22-03-2022 13:05 P.M.",
            "Operadora solicita 10 rollo térmicos para impresora de tickets",
            "Solicitud de rollos térmicos",
            true,
            "Gobierno de estado de México",
            "Katherune Rios Ruano",
            "5558478421",
            "Dependencia de Gobierno",
            "NA",
            true
        ),
        Ticket(
            "INC-2022-08364",
            "LICENCIAS ESTADO DE MÉXICO",
            "ATIZAPAN DE ZARAGOZA",
            "INSTITUTO DE SEGURODAD SOCIAL DEL ESTADO DE MÉXIC",
            "22-03-2022 13:05 P.M.",
            "15-03-2022 11:15 A.M.",
            "Desconfiguración de terminal de cobro (error please enter password",
            "Operador reporta desconfiguración de terminal de cobro Roberto de la Cruz Martinez contacto 5579091873 correo toxiatzipan@cosmocolor.com.mx Boulevard Adolfo López Mateos S/N, Puerta B-106 colonia el potrero, atizapan de zaragoza, estado de México. CP. 52975",
            false,
            "Gobierno de estado de México",
            "Roberto De la Cruz Martinez",
            "5579091873",
            "Perosnal Operativo Cliente",
            "NA",
            true
        ), Ticket(
            "INC-2022-10319",
            "Licencias Estado de México",
            "Los Reyes La Paz",
            "Secretaría de movilidad del Estado de México",
            "Incidente",
            "22-03-2022 13:05 P.M.",
            "Solicitan 2 perforadras para mermar las licencias contacto 5575106342",
            "Comenta que requieren ambas perforadoras tenían una y ya se dañó",
            true,
            "Gobierno de estado de México",
            "Operador Licencias Estado de México",
            "5584328951",
            "Personal operativo cliente",
            "NA",
            false
        ),
        Ticket(
            "INC-2022-10296",
            "Licencias Estado de México",
            "Nezahualcoyotl Tarjetas",
            "Secretaría de movilidad del Estado de México",
            "Incidente",
            "24-03-2022 11:35 P.M.",
            "marycaster.movilidad@gmaill.com Cambio de mouse/toxi neza se solicita cambio de mouse en orden 2 ya que cursor al pulsa no seleccciona correctamente Marca HP CT FFCMHH0CZC6ERH",
            "Cambo de mouse",
            true,
            "Gobierno de estado de México",
            "Operador Licencias Estado de México",
            "5586091132",
            "Personal operativo cliente",
            "NA",
            false
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