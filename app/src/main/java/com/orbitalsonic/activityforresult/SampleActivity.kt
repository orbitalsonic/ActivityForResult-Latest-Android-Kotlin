package com.orbitalsonic.activityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SampleActivity : AppCompatActivity() {

    private lateinit var btnDone: Button
    private val sampleData = "Sample Activity Result Data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        btnDone = findViewById(R.id.btn_done)
        btnDone.setOnClickListener{
            returnForResult()
        }
    }

    private fun returnForResult(){
        val replyIntent = Intent()
        replyIntent.putExtra(
            "result_data",
            sampleData
        )
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }
}