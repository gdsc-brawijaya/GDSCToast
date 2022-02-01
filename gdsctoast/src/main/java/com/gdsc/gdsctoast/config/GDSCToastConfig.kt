package com.gdsc.gdsctoast.config

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.gdsc.gdsctoast.R
import com.gdsc.gdsctoast.databinding.GdscToastLayoutBinding
import com.gdsc.gdsctoast.util.ToastShape
import com.gdsc.gdsctoast.util.ToastType

/**
 * Available since version 1.2.0
 * Configuration class for GDSCToast
 */
class GDSCToastConfig(private val context: Context) {

    var text: String = ""
    var toastType: ToastType = ToastType.INFO
    var showLogo: Boolean = true
    var duration: Int = Toast.LENGTH_SHORT
    var toastShape: ToastShape = ToastShape.ROUNDED

    private val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    private fun buildToast(): Toast {
        val toast = Toast(context)
        val layout = GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)

        layout.apply {
            when(toastShape) {
                ToastShape.ROUNDED -> toastIdentifier.background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                ToastShape.RECTANGLE -> toastIdentifier.background = ResourcesCompat.getDrawable(context.resources, R.drawable.rectangle_shape, null)
            }

            when (toastType) {
                ToastType.NORMAL -> {
                    toastIdentifier.background.setTint(ContextCompat.getColor(context, R.color.gray))

                    val params = tvInformation.layoutParams as ViewGroup.MarginLayoutParams
                    params.apply {
                        marginStart = 12.dp
                        topMargin = 8.dp
                        bottomMargin = 8.dp
                        marginEnd = 12.dp
                    }
                    tvInformation.layoutParams = params
                    ivCondition.visibility = View.GONE
                }
                ToastType.SUCCESS -> {
                    toastIdentifier.background.setTint(ContextCompat.getColor(context, R.color.green))
                    ivCondition.setImageResource(R.drawable.ic_success)
                }
                ToastType.ERROR -> {
                    toastIdentifier.background.setTint(ContextCompat.getColor(context, R.color.red))
                    ivCondition.setImageResource(R.drawable.ic_error)
                }
                ToastType.WARNING -> {
                    toastIdentifier.background.setTint(ContextCompat.getColor(context, R.color.yellow))
                    ivCondition.setImageResource(R.drawable.ic_warning)
                }
                ToastType.INFO -> {
                    toastIdentifier.background.setTint(ContextCompat.getColor(context, R.color.blue))
                    ivCondition.setImageResource(R.drawable.ic_info)
                }
            }

            if (showLogo && (toastType == ToastType.WARNING || toastType == ToastType.INFO))
                ivGdscLogoDownside.visibility = View.VISIBLE
            else if (showLogo && (toastType == ToastType.NORMAL || toastType == ToastType.SUCCESS || toastType == ToastType.ERROR))
                ivGdscLogoUpside.visibility = View.VISIBLE
            else
                ivGdscLogoDownside.visibility = View.INVISIBLE

            tvInformation.text = text

            toast.apply {
                duration = duration
                view = layout.root
            }
        }

        return toast
    }

    /**
     * * Available since version 1.2.0
     * * Allow you to access configuration of GDSCToast
     * * Example:
     * GDSCToast.configOn(this).setText("Hello this is an success toast")
     *
     * @param text to set message that will shown from toast
     * @param text default value => ""
     */
    fun setText(text: String): GDSCToastConfig {
        this.text = text
        return this
    }

    /**
     * * Available since version 1.2.0
     * * Allow you to access configuration of GDSCToast
     * * Example:
     * GDSCToast.configOn(this).setToastType(ToastType.SUCCESS)
     *
     * @param toastType to set type of toast
     * @param toastType default value => ToastType.NORMAL
     */
    fun setToastType(toastType: ToastType): GDSCToastConfig {
        this.toastType = toastType
        return this
    }

    /**
     * * Available since version 1.2.0
     * * Allow you to access configuration of GDSCToast
     * * Example:
     * GDSCToast.configOn(this).setShowLogo(false)
     *
     * @param showLogo to set visibility of GDSC logo
     * @param showLogo default value => true
     */
    fun setShowLogo(showLogo: Boolean): GDSCToastConfig {
        this.showLogo = showLogo
        return this
    }

    /**
     * * Available since version 1.2.0
     * * Allow you to access configuration of GDSCToast
     * * Example:
     * GDSCToast.configOn(this).setDuration(Toast.LENGTH_LONG)
     *
     * @param duration to set duration of toast
     * @param duration default value => Toast.LENGTH_SHORT
     */
    fun setDuration(duration: Int): GDSCToastConfig {
        this.duration = duration
        return this
    }

    /**
     * * Available since version 1.2.0
     * * Allow you to access configuration of GDSCToast
     * * Example:
     * GDSCToast.configOn(this).setToastShape(ToastShape.RECTANGLE)
     *
     * @param toastShape to set shape of toast
     * @param toastShape default value => ToastShape.ROUNDED
     */
    fun setToastShape(toastShape: ToastShape): GDSCToastConfig {
        this.toastShape = toastShape
        return this
    }

    /**
     * * Available since version 1.2.0
     * * Call this function in the line of all configurations
     * * @return Toast object so you still can customized the toast
     * * Example:
     * GDSCToast.configOn(this)
     *     .setText("Internet connection interrupted")
     *     .setToastType(ToastType.ERROR)
     *     .makeToast()
     */
    fun makeToast(): Toast = buildToast()

    /**
     * * Available since version 1.2.0
     * * Call this function in the last line of all configurations
     * * Show the toast instead of make it
     * * Example:
     * GDSCToast.configOn(this)
     *     .setText("Internet connection interrupted")
     *     .setToastType(ToastType.ERROR)
     *     .show()
     */
    fun showToast() = makeToast().show()
}