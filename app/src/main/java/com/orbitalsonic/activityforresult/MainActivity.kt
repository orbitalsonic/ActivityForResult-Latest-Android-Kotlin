package com.orbitalsonic.activityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        btnNext = findViewById(R.id.btn_next)

        btnNext.setOnClickListener {
            openActivityForResult(Intent(this,SampleActivity::class.java))
        }

    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val mIntent: Intent? = result.data
            val mDataString = mIntent?.getStringExtra("result_data")
            tvResult.text = mDataString

        }
    }

    private fun openActivityForResult(mIntent: Intent) {
        resultLauncher.launch(mIntent)
    }
}