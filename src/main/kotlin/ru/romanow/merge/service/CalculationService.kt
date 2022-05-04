package ru.romanow.merge.service

interface CalculationService {
    fun eval(expression: String): Double
}