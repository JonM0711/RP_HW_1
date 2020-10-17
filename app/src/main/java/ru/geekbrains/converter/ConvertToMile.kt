package ru.geekbrains.converter

// Реализация интерфейса ConvertTo.
// Перевод в Мили из КМ.
internal class ConvertToMile : ConvertTo {
    override fun Do(sourceValue: Float): Float {
        return (sourceValue * 0.62137).toFloat() // Вычисление миль
    }
}