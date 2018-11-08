package com.sedmandev.stylistmanager.model

import java.util.*

data class Appointment(val id: Int, val name: String, val client: Client, val date: Date)