package com.sedmandev.stylistmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Appointment(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val completed: Boolean
)