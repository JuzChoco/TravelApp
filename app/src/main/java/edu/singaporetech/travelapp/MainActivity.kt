package edu.singaporetech.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.singaporetech.travelapp.databinding.ActivityMainBinding

/**
 * Lab 02: Travel App
 * Main Screen
 *
 * 2020-01-27: port to kotlin (jeannie)
 * 2023-01-18: fixes for latest platform level
 */
class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d(TAG, "onCreate")
        Log.d(TAG, "Attack of the killer androids");

        binding.tempConverterButton.setOnClickListener{ temperatureConverterButtonOnClick() }
        binding.currencyConverterButton.setOnClickListener{ currencyConverterButtonOnClick() }
        binding.emailFriendButton.setOnClickListener{ emailFriendButtonOnClick() }
    }

    private fun temperatureConverterButtonOnClick(){
        val intent = Intent(this,TempConverterActivity::class.java)
        startActivity(intent)
    }

    private fun currencyConverterButtonOnClick(){
        val intent = Intent(this,CurrencyConverterActivity::class.java)
        startActivity(intent)
    }

    private fun emailFriendButtonOnClick(){
        val intent = Intent(this,EmailActivity::class.java)
        startActivity(intent)
    }
}