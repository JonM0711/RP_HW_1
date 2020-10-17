package ru.geekbrains.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class ConvertActivity : AppCompatActivity() {
    private var sourceText // Элемент с входным значением, которое надо сконвертировать
            : EditText? = null
    private var destText // Элемент с результирующим значением
            : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        sourceText = findViewById<View>(R.id.celsiusValue) as EditText
        destText = findViewById<View>(R.id.fahrenheitValue) as EditText
    }

    // обработка нажатия
    fun onToFahrenheitClick(view: View?) {
        // получить входное значение
        val sourceValue = sourceText!!.text.toString().toFloat()
        // инстанцировать конвертер
        val converter = Converter(sourceValue)
        // преобразовать, обратите внимание на параметр ConvertToFahrenheit
        val destValue = converter.Convert(ConvertToFahrenheit()).GetResult()
        // записать результат в элемент
        destText!!.setText(String.format("%.02f", destValue))
    }
}