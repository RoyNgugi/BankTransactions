package com.example.banktransactions.dataclass

import java.util.Date

data class Transactons(
        val targetAccount: String,
        val value: Double?,
        val description: String,
        val date: Date?,
        val id: String?

)
