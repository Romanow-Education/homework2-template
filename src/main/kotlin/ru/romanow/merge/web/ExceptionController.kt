package ru.romanow.merge.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.romanow.merge.exceptions.WrongBracketsException

@RestControllerAdvice
class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongBracketsException::class)
    fun badRequest(exception: WrongBracketsException) = ErrorResponse(exception.message)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException::class)
    fun error(exception: RuntimeException) = ErrorResponse(exception.message)

    data class ErrorResponse(val message: String?)
}