package com.gdsc.gdsctoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gdsc.gdsctoast.GDSCToast.Companion.buildNormalToast
import com.gdsc.gdsctoast.GDSCToast.Companion.configOn
import com.gdsc.gdsctoast.GDSCToast.Companion.showAnyToast
import com.gdsc.gdsctoast.GDSCToast.Companion.showSuccessToast
import com.gdsc.gdsctoast.databinding.ActivityMainBinding
import com.gdsc.gdsctoast.util.ToastShape
import com.gdsc.gdsctoast.util.ToastType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnNormal.setOnClickListener {
                GDSCToast.showNormalToast(this@MainActivity, "This is a normal toast", Toast.LENGTH_LONG)
                GDSCToast.apply { this@MainActivity.buildNormalToast("This is normal toast").show() }
                this@MainActivity.apply { buildNormalToast("This is normal toast").show() }
            }
            btnSuccess.setOnClickListener {
                GDSCToast.buildSuccessToast(this@MainActivity, "This is a success toast", Toast.LENGTH_LONG).show()
                GDSCToast.apply { this@MainActivity.showSuccessToast("This is success toast") }
                this@MainActivity.apply { showSuccessToast("This is success toast") }
            }
            btnError.setOnClickListener {
                GDSCToast.buildErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG).show()
                GDSCToast.showErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG)
            }
            btnWarning.setOnClickListener {
                GDSCToast.buildWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG).show()
                GDSCToast.showWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG)
            }
            btnInfo.setOnClickListener {
                GDSCToast.buildInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG).show()
                GDSCToast.showInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG)
            }
            btnConfig.setOnClickListener {
                GDSCToast.configOn(this@MainActivity)
                    .setText("Hello this is from 1.2.0 ver")
                    .setDuration(Toast.LENGTH_LONG)
                    .setShowLogo(true)
                    .setToastShape(ToastShape.RECTANGLE)
                    .setToastType(ToastType.SUCCESS)
                    .showToast()

                this@MainActivity.apply {
                    configOn().setText("Hello this is from 1.2.2 ver")
                        .setDuration(Toast.LENGTH_LONG)
                        .setShowLogo(true)
                        .setToastShape(ToastShape.RECTANGLE)
                        .setToastType(ToastType.SUCCESS)
                        .showToast()
                }

                GDSCToast.apply {
                    this@MainActivity.configOn().setText("Hello this is from 1.2.2 ver")
                        .setDuration(Toast.LENGTH_LONG)
                        .setShowLogo(true)
                        .setToastShape(ToastShape.RECTANGLE)
                        .setToastType(ToastType.SUCCESS)
                        .showToast()
                }
            }
            btnConfig2.setOnClickListener {
                GDSCToast.showAnyToast(this@MainActivity) {
                    it.apply {
                        text = "Hello this is from 1.2.1 ver"
                        duration = Toast.LENGTH_LONG
                        showLogo = false
                        toastShape = ToastShape.RECTANGLE
                        toastType = ToastType.ERROR
                    }
                }

                this@MainActivity.apply {
                    showAnyToast {
                        it.apply {
                            text = "Hello this is from 1.2.2 ver"
                            duration = Toast.LENGTH_LONG
                            showLogo = false
                            toastShape = ToastShape.RECTANGLE
                            toastType = ToastType.ERROR
                        }
                    }
                }

                GDSCToast.apply {
                    this@MainActivity.showAnyToast {
                        it.apply {
                            text = "Hello this is from 1.2.2 ver"
                            duration = Toast.LENGTH_LONG
                            showLogo = false
                            toastShape = ToastShape.RECTANGLE
                            toastType = ToastType.ERROR
                        }
                    }
                }
            }
        }
    }
}