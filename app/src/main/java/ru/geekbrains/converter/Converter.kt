package ru.geekbrains.converter

// Класс Converter отвечает за различные преобразования
// и является связующим звеном между Activity и самими преобразованиями.
// Таким образом, чтобы сделать какое-либо новое преобразование, достаточно
// реализовать интерфейс ConvertTo.
internal class Converter(   // Конструктор, в качестве параметра передаем исходное значение
        private val _sourceValue: Float) { // Значение, которое надо сконвертировать
        private var _destValue = 0f // Сконвертированное значение

    // Метод конвертирует значения
    // ConvertTo - конвертирующий значения интерфейс
    fun Convert(convertTo: ConvertTo): Converter {
        // Передаем в интерфейс исходное значение, получаем сконвертированное
        _destValue = convertTo.Do(_sourceValue)

        // Здесь класс возвращает сам себя, для удобства работы.
        return this
    }

    // Метод возвращает результат
    fun GetResult(): Float {
        return _destValue
    }
}