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
            btnNormal.setOnClickListener {
                GDSCToast.makeNormalToast(this@MainActivity, "This is a normal toast", Toast.LENGTH_LONG).show()
                GDSCToast.showNormalToast(this@MainActivity, "This is a normal toast", Toast.LENGTH_LONG)
            }
            btnSuccess.setOnClickListener {
                GDSCToast.makeSuccessToast(this@MainActivity, "This is a success toast", Toast.LENGTH_LONG).show()
                GDSCToast.showSuccessToast(this@MainActivity, "This is a success toast", Toast.LENGTH_LONG)
            }
            btnError.setOnClickListener {
                GDSCToast.makeErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG).show()
                GDSCToast.showErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG)
            }
            btnWarning.setOnClickListener {
                GDSCToast.makeWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG).show()
                GDSCToast.showWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG)
            }
            btnInfo.setOnClickListener {
                GDSCToast.makeInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG).show()
                GDSCToast.showInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG)
            }
        }
    }
}