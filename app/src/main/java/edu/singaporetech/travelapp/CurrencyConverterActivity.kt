package edu.singaporetech.travelapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.singaporetech.travelapp.databinding.ActivityCurrencyConverterBinding

/**
 * Activity that displays UI to convert currency
 */
class CurrencyConverterActivity : AppCompatActivity() {

    val TAG: String = "CurrencyConverterActivity"
    private lateinit var binding: ActivityCurrencyConverterBinding

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyConverterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d(TAG, "Made ActivityCurrencyConverter the active view on the screen!");

        binding.buttonConvert.setOnClickListener{ buttonConvertOnClick() }
    }

    /**
     * Formula to calculate the destination currency
     * @param value
     * @param exchangeRate
     * @return
     */
    private fun buttonConvertOnClick() {
        val getCurrency = binding.editTextCurrency.text
        val getRate = binding.editTextRate.text.toString().toFloat()
        val getValue = binding.editTextSingDollar.text.toString().toFloat()
        val result = calculateRate(getValue, getRate)
        val resultString = getString(R.string.result_conv_textview, getValue, result, getCurrency)
        binding.textViewResult.text = resultString
    }
    private fun calculateRate(value: Float, exchangeRate: Float): Float {
        return value * exchangeRate
    }

}