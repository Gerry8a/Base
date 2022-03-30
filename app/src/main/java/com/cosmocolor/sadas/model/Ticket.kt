package com.cosmocolor.sadas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import com.cosmocolor.sadas.util.Constanst
import com.cosmocolor.sadas.util.Constanst.CONFLIC_TABLE
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = CONFLIC_TABLE)
data class Ticket(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val nombreProyecto: String,
    val unidadOperativa: String,
    val areaCliente: String,
    val tipoIncidente: String,
    val fechaSolicitud: String,
    val problema: String,
    val descripcionProblema: String,
    val operando: Boolean,
    val cliente: String,
    val contactoCliente: String,
    val numeroCliente: String,
    val fallaImputable: String,
    val numeroIncidente: String,
    val terminado: Boolean
): Parcelable