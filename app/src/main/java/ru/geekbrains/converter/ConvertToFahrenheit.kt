package ru.geekbrains.converter

// Реализация интерфейса ConvertTo.
// Перевод в Фаренгейт из Цельсия.
internal class ConvertToFahrenheit : ConvertTo {
    override fun Do(sourceValue: Float): Float {
        return (sourceValue * 1.8 + 32).toFloat() // Вычисление Фаренгейт
    }
}