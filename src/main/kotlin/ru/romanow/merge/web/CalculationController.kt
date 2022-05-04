package ru.romanow.merge.web

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.romanow.merge.service.CalculationService

@RestController
@RequestMapping("/api/v1/eval")
class CalculationController(
    private val calculationService: CalculationService
) {

    @PostMapping(consumes = [MediaType.TEXT_PLAIN_VALUE], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun eval(@RequestBody expression: String): String {
        return calculationService.eval(expression).toString()
    }
}