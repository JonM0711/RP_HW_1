package ru.geekbrains.converter

// Реализация интерфейса ConvertTo.
// Перевод в Цельсии из Фаренгейта.
internal class ConvertToCelsius : ConvertTo {
    override fun Do(sourceValue: Float): Float {
        return ((sourceValue - 32) / 1.8).toFloat() // Вычисление Цельсия
    }
}