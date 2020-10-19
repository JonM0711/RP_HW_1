package ru.geekbrains.converter

internal class ConvertKmhToMs: ConvertTo {
    override fun Do(sourceValue: Float): Float {
        return (sourceValue * 0.277778).toFloat() // Вычисление метров в секунду
    }
}