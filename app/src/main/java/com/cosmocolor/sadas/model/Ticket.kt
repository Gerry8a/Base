package com.cosmocolor.sadas.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ticket(
    val id: String,
    val nombreProyecto: String,
    val unidadOperativa: String,
    val areaCliente: String,
//    val tipoIncidente: Int,
    val fechaSolicitud: String
): Parcelable