package com.cosmocolor.sadas.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cosmocolor.sadas.data.Repository
import com.cosmocolor.sadas.model.Ticket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class IncidentViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private fun insertTikcet(ticket: Ticket) = viewModelScope.launch(Dispatchers.IO) {
        repository.local.insertTicket(ticket)
    }

}