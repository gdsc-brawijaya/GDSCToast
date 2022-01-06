package com.gdsc.gdsctoast

/**
 * GDSCToast
 * Copyright (c) 2021 all rights reserved.
 * Created by Kylix Eza Saputra as Learning Development Android Google Developer Student Club University of Brawijaya
 * Contact me if you find any bugs or just want to collaborate in this project
 */

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.gdsc.gdsctoast.databinding.GdscToastLayoutBinding
import com.gdsc.gdsctoast.util.GDSCToastConfig

/**
 * Class that contains some toast functions
 */
class GDSCToast {
    companion object {

        private val Int.dp: Int
            get() = (this * Resources.getSystem().displayMetrics.density).toInt()

        /**
         * * Call this function to make a normal toast (you can check the pict of normal toast on github Readme.md)
         * * Example:
         * GDSCToast.makeNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can make an object of the toast so you can customize your own toast
         * * Example:
         * val normalToast = GDSCToast.makeNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */

        fun makeNormalToast(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.apply {
                    background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                    background.setTint(ContextCompat.getColor(context, R.color.gray))
                }

                val params = tvInformation.layoutParams as ViewGroup.MarginLayoutParams
                params.apply {
                    marginStart = 12.dp
                    topMargin = 8.dp
                    bottomMargin = 8.dp
                    marginEnd = 12.dp
                }
                tvInformation.layoutParams = params

                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.visibility = View.GONE
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showNormalToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeNormalToast(context, text, duration, showLogo).show()

        /**
         * * Call this function to make a success toast (you can check the pict of success toast on github Readme.md)
         * * Example:
         * GDSCToast.makeSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can make an object of the toast so you can customize your own toast
         * * Example:
         * val successToast = GDSCToast.makeSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun makeSuccessToast(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.apply {
                    background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                    background.setTint(ContextCompat.getColor(context, R.color.green))
                }
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.setImageResource(R.drawable.ic_success)
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showSuccessToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeSuccessToast(context, text, duration, showLogo).show()

        /**
         * * Call this function to make a error toast (you can check the pict of error toast on github Readme.md)
         * * Example:
         * GDSCToast.makeErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can make an object of the toast so you can customize your own toast
         * * Example:
         * val errorToast = GDSCToast.makeErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun makeErrorToast(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.apply {
                    background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                    background.setTint(ContextCompat.getColor(context, R.color.red))
                }
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.setImageResource(R.drawable.ic_error)
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showErrorToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeErrorToast(context, text, duration, showLogo).show()

        /**
         * * Call this function to make a warning toast (you can check the pict of warning toast on github Readme.md)
         * * Example:
         * GDSCToast.makeWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can make an object of the toast so you can customize your own toast
         * * Example:
         * val warningToast = GDSCToast.makeWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun makeWarningToast(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.apply {
                    background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                    background.setTint(ContextCompat.getColor(context, R.color.yellow))
                }
                if (showLogo)
                    ivGdscLogoDownside.visibility = View.VISIBLE
                else
                    ivGdscLogoDownside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.setImageResource(R.drawable.ic_warning)
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showWarningToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeWarningToast(context, text, duration, showLogo).show()

        /**
         * * Call this function to make a info toast (you can check the pict of info toast on github Readme.md)
         * * Example:
         * GDSCToast.makeInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can make an object of the toast so you can customize your own toast
         * * Example:
         * val infoToast = GDSCToast.makeInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun makeInfoToast(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.apply {
                    background = ResourcesCompat.getDrawable(context.resources, R.drawable.rounded_shape, null)
                    background.setTint(ContextCompat.getColor(context, R.color.blue))
                }
                if (showLogo)
                    ivGdscLogoDownside.visibility = View.VISIBLE
                else
                    ivGdscLogoDownside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.setImageResource(R.drawable.ic_info)
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showInfoToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeInfoToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.0
         * * Allow you to access configuration of GDSCToast
         * * Example:
         * GDSCToast.configOn(this)
         *
         * @param context to get context from activity or fragment
         */
        fun configOn(context: Context): GDSCToastConfig {
            val config = GDSCToastConfig()
            config.context = context
            return config
        }

        private fun buildToast(context: Context): GdscToastLayoutBinding =
            GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    }
}