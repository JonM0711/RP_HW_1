package ru.geekbrains.converter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class ConvertActivity : AppCompatActivity() {
    private var sourceText : EditText? = null // Элемент с входным значением, которое надо сконвертировать
    private var destText : EditText? = null // Элемент с результирующим значением

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        sourceText = findViewById<View>(R.id.inputValue) as EditText
        destText = findViewById<View>(R.id.outputValue) as EditText
    }

    // обработка нажатия
    fun onConvertClick(view: View?) {
        // получить входное значение
        val sourceValue = sourceText!!.text.toString().toFloat()
        // инстанцировать конвертер
        val converter = Converter(sourceValue)
        // преобразовать, обратите внимание на параметр ConvertToFahrenheit
        val destValue = converter.Convert(ConvertKmhToMs()).GetResult()
        // записать результат в элемент
        destText!!.setText(String.format("%.02f", destValue))
    }
}