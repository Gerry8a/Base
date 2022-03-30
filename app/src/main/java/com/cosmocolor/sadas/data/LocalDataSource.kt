package com.cosmocolor.sadas.data

import com.cosmocolor.sadas.data.database.TicketDao
import com.cosmocolor.sadas.model.Ticket
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val ticketDao: TicketDao
) {
    suspend fun insertTicket(ticket: Ticket){
        ticketDao.insertTicket(ticket)
    }
}