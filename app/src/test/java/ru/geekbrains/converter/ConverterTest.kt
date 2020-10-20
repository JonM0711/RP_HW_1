package ru.geekbrains.converter

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
//import org.mockito.runners.MockitoJUnitRunner
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ConverterTest {
    // Тестируем Converter.Convert
    @Test
    @Throws(Exception::class)
    fun Converter_Convert_UnitTest() {

        // Создаем мок-объект по интерфейсу ConvertTo
        val convertTo = Mockito.mock(ConvertTo::class.java)
        val sourceValue = 22f // Это исходное значение
        val converter = Converter(sourceValue)

        // Подставляем мок-объект в качестве реализации в метод конвертера
        converter.Convert(convertTo)

        // Нам интересно то, что метод Do интерфейса ConvertTo был вызван.
        Mockito.verify(convertTo).Do(22f)
    }

    // Тестируем Converter.GetResult
    @Test
    @Throws(Exception::class)
    fun Converter_GetResult_UnitTest() {
        val sourceValue = 22f
        val converter = Converter(sourceValue)
        val actual = converter.GetResult() // Получить результат, неважно что вычислили

        // assertThat использует матчеры, is это матчер
        Assert.assertThat(actual, CoreMatchers.`is`(0f)) // тип float по умолчанию имеет значенрие 0
    }

    // Интеграционный тест, проверяем взаимодействие объекта Converter и ConvertToFahrenheit
    @Test
    @Throws(Exception::class)
    fun Converter_IntegrationTest() {
        val sourceValue = -15f
        val converter = Converter(sourceValue)
        // Вместо мок-объекта используем реальный объект
        val actual = converter.Convert(ConvertToFahrenheit()).GetResult()
        Assert.assertThat(actual, CoreMatchers.`is`(5f))
    }

    @Test
    @Throws(Exception::class)
    fun ConvertToCelsius_Do_UnitTest() {
        val convertTo: ConvertTo = ConvertToCelsius()
        val actual = convertTo.Do(5f)
        Assert.assertThat(actual, CoreMatchers.`is`(-15f))
    }

    @Test
    @Throws(Exception::class)
    fun ConvertToFahrenheit_Do_UnitTest() {
        val convertTo: ConvertTo = ConvertToFahrenheit()
        val actual = convertTo.Do(-15f)
        Assert.assertThat(actual, CoreMatchers.`is`(5f))
    }

    @Test
    @Throws(Exception::class)
    fun ConvertToMile_Do_UnitTest() {
        val convertTo: ConvertTo = ConvertToMile()
        val actual = convertTo.Do(2f)
        Assert.assertThat(actual, CoreMatchers.`is`(1.24274f))
    }

    @Test
    @Throws(Exception::class)
    fun ConvertKmhToMs_Do_UnitTest() {
        val convertTo: ConvertTo = ConvertKmhToMs()
        val actual = convertTo.Do(1f)
        Assert.assertThat(actual, CoreMatchers.`is`(0.2777778f))
    }
}