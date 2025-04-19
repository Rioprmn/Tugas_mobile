package com.example.implicit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.parseAsHtml
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val websiteEdit: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener{
            val websiteUrl = websiteEdit.text.toString()
            openWebsite(websiteUrl)
        }

        val locationEdit: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_button)
        locationButton.setOnClickListener {
            val location = locationEdit.text.toString()
            openLocation(location)
        }

        val shareEdit: EditText = findViewById(R.id.share_edit_text)
        val shareButton: Button = findViewById(R.id.share_text_button)
        shareButton.setOnClickListener {
            val text = shareEdit.text.toString()
            shareText(text)
        }

        val implicitEdit: EditText = findViewById(R.id.implicit_edit_text)
        val implicitButton: Button = findViewById(R.id.implicit_button)
        implicitButton.setOnClickListener {
            val text = implicitEdit.text.toString()
            sendData(text)
        }
    }
    private fun openWebsite(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun openLocation(location: String){
        val url = Uri.parse( "geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, url)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun shareText(text: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type ="text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent,  "Pilih Aplikasi"))
    }
    private fun sendData(text: String){
        val intent = Intent ( this, SecondActivity::class.java)
        intent.putExtra("LOCK" ,text)
        startActivity(intent)
    }


}