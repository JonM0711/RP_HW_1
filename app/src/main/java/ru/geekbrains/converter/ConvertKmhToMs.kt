package ru.geekbrains.converter

internal class ConvertKmhToMs: ConvertTo {
    override fun Do(sourceValue: Float): Float {
        return (sourceValue / 3.6).toFloat() // Вычисление метров в секунду
    }
}