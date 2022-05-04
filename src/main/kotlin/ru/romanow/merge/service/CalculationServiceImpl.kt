package ru.romanow.merge.service

import org.springframework.stereotype.Service

@Service
class CalculationServiceImpl : CalculationService {
    override fun eval(expression: String): Double {
        return 0.0
    }
}