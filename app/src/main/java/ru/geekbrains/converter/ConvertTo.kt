package ru.geekbrains.converter

// Интерфейс преобразования значений
// Чтобы сделать новое преобразование, достаточно реализовать этот интерфейс
internal interface ConvertTo {
    fun Do(sourceValue: Float): Float // Преобразовать
}