package com.mksoftware101.personalnotes.domain.model

import java.time.LocalDateTime

data class Note(
    val Id: Long,
    val title: String,
    val data: String?,
    val creationDateTime: LocalDateTime,
    val isFavourite: Boolean
)
