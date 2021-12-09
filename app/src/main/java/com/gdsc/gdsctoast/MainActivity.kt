package com.gdsc.gdsctoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gdsc.gdsctoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSuccess.setOnClickListener {
                GDSCToast.makeSuccessToast(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
            }
            btnNormal.setOnClickListener {
                GDSCToast.makeNormalToast(this@MainActivity, "Normal", Toast.LENGTH_LONG).show()
            }
            btnError.setOnClickListener {
                GDSCToast.makeErrorToast(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }
            btnWarning.setOnClickListener {
                GDSCToast.makeWarningToast(this@MainActivity, "Warning", Toast.LENGTH_LONG).show()
            }
            btnInfo.setOnClickListener {
                GDSCToast.makeInfoToast(this@MainActivity, "Info", Toast.LENGTH_LONG).show()
            }
        }
    }
}