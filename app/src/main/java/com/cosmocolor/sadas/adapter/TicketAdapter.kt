package com.cosmocolor.sadas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cosmocolor.sadas.R
import com.cosmocolor.sadas.databinding.ActivityMainBinding
import com.cosmocolor.sadas.databinding.ItemTicketBinding
import com.cosmocolor.sadas.model.Ticket


class TicketAdapter(
    private val ticketsList: List<Ticket>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TicketAdapter.ViewHolder>() {

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding = ItemTicketBinding.bind(view)

        fun render(ticket: Ticket) {
            binding.tvId.text = ticket.id
            binding.tvFecha.text = ticket.fechaSolicitud
            binding.tvNombreProyecto.text = ticket.nombreProyecto
            binding.tvUnidadOperativa.text = ticket.unidadOperativa
            binding.tvAreaCliente.text = ticket.areaCliente
        }

        fun click(ticket: Ticket, listener: OnItemClickListener){
            itemView.setOnClickListener {
                listener.onClick(ticket)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_ticket, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket = ticketsList[position]
        holder.render(ticket)
        holder.click(ticket, listener)
    }

    override fun getItemCount(): Int = ticketsList.size

    interface OnItemClickListener{
        fun onClick(ticket: Ticket)
    }


}