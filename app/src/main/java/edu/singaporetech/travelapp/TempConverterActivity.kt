package edu.singaporetech.travelapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.singaporetech.travelapp.databinding.ActivityTempConverterBinding


/**
 * Activity that displays UI to convert temperature
 */
class TempConverterActivity : AppCompatActivity() {

    val TAG: String = "TempConverter"
    private lateinit var binding: ActivityTempConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTempConverterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d(TAG, "Made TempConverter the active view on the screen!");

        binding.buttonConvert.setOnClickListener { convertButtonOnClick() }
        binding.buttonClear.setOnClickListener { clearButtonOnClick() }
    }

    //To perform temp conversion onClick
    private fun convertButtonOnClick() {
        if (binding.fahrenheitRadio.isChecked) {
            val inputTemperature: Float = binding.editTextTemp.text.toString().toFloat()
            val result: Float = convertCelsiusToFahrenheit(inputTemperature)
            val resultString =
                getString(R.string.result_tofahrenheit_textview, inputTemperature, result)
            binding.textViewResult.text = resultString
        } else {
            val inputTemperature: Float = binding.editTextTemp.text.toString().toFloat()
            val result: Float = convertFahrenheitToCelsius(inputTemperature)
            val resultString =
                getString(R.string.result_tocelsius_textview, inputTemperature, result)
            binding.textViewResult.text = resultString
        }
    }

    //To clear the editText field
    private fun clearButtonOnClick() {
        binding.editTextTemp.setText("")
        binding.textViewResult.text = ""
        binding.tempRadioGroup.clearCheck()
    }

    /**
     * Converts fahrenheit to celsius
     * @param fahrenheit temperature in f
     * @return
     */
    private fun convertFahrenheitToCelsius(fahrenheit: Float): Float {
        val celsius: Double = (fahrenheit - 32) * 0.5556
        return celsius.toFloat()
    }

    /**
     * Converts celsius to fahrenheit
     * @param celsius temperature in c
     * @return
     */
    private fun convertCelsiusToFahrenheit(celsius: Float): Float {
        val fahrenheit: Double = (celsius * 1.8) + 32
        return fahrenheit.toFloat()
    }

}