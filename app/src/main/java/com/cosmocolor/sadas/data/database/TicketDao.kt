package com.cosmocolor.sadas.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cosmocolor.sadas.model.Ticket

interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTicket(ticket: Ticket)
}