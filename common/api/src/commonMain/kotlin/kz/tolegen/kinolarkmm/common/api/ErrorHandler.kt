package kz.tolegen.kinolarkmm.common.api

import io.github.aakira.napier.Napier
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*

fun proceedError(
    error: Throwable,
    messageListener: (String) -> Unit = {},
) {
    Napier.e("Iris Error", error)
    messageListener(error.toHumanReadableMessage())
}

private fun Throwable.toHumanReadableMessage(): String = when (this) {
    is ResponseException -> when (response.status.value) {
        401 -> "Ошибка авторизации"
        403 -> "Доступ запрещён"
        500 -> "Ошибка сервера"
        else -> "Неизвестная ошибка"
    }
    is IOException -> "Ошибка подключения к серверу"
    else -> "Неизвестная ошибка"
}