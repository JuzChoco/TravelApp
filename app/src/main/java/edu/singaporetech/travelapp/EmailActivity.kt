package edu.singaporetech.travelapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import edu.singaporetech.travelapp.databinding.ActivityEmailBinding

/**
 * Activity that emails your friend with a message
 */
class EmailActivity : AppCompatActivity() {

    val TAG: String = "EmailActivity"
    private lateinit var binding: ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d(TAG, "onCreate")
        Log.d(TAG, createEmailMessage("Jeannie", "Los Angeles"))
        Log.d(TAG, "setContentView--> Made ActivityEmail the active view on the screen!");

        binding.buttonPreviewMessage.setOnClickListener {
            var name : String = binding.editTextName.text.toString()
            var city : String = binding.editTextCity.text.toString()
            var emailMessage : String = createEmailMessage(name, city)
            binding.textViewPreview.text = emailMessage
        }
        binding.buttonSendEmail.setOnClickListener { sendEmailButtonOnClick() }
    }


    private fun sendEmailButtonOnClick(){
        val name = binding.editTextName.text.toString()
        val city = binding.editTextCity.text.toString()
        val email = binding.editTextEmail.text.toString()
        sendEmail(email, name, city)
    }

    /**
     * Call an intent to start the email app
     */
    private fun sendEmail(email: String, name: String, city: String) { // do you need to change the parameters?
        val message = createEmailMessage(name, city)
        val address: Array<String> = arrayOf(email)
        val subject = getString(R.string.email_subject)

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    /**
     * Creates the string to send in the email message
     * @param name
     * @param city
     * @return the email message
     */
    private fun createEmailMessage(name: String, city: String): String {

        val emailMessage: String = getString(R.string.hey) + " " + name + " " + getString(R.string.im_going_to) + " " + city + "!"

        return emailMessage
    }

}