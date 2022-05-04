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
import com.gdsc.gdsctoast.config.GDSCToastConfig

/**
 * Class that contains some toast functions
 */
class GDSCToast {
    companion object {

        private val Int.dp: Int
            get() = (this * Resources.getSystem().displayMetrics.density).toInt()

        /**
         * * Call this function to build a normal toast (you can check the pict of normal toast on github Readme.md)
         * * Example:
         * GDSCToast.buildNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can build an object of the toast so you can customize your own toast
         * * Example:
         * val normalToast = GDSCToast.buildNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */

        fun buildNormalToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
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
         * * Available since version 1.2.2
         * * buildNormalToast with Context extension
         * * Example:
         * val normalToast = this@TheActivity.apply{ buildNormalToast("Hello this is normal toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("buildNormalToast-with-Context-extension")
        fun Context.buildNormalToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
            return buildNormalToast(this, text, duration, showLogo)
        }

        /**
         * * Shortcut if you just want to show the toast without any customization
         * * Example:
         * GDSCToast.showNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showNormalToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildNormalToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.2
         * * showNormalToast with Context extension
         * * Example:
         * this@TheActivity.apply{ showNormalToast("Hello this is normal toast", Toast.LENGTH_SHORT, true) }
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("showNormalToast-with-Context-extension")
        fun Context.showNormalToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            showNormalToast(this, text, duration, showLogo)

        /**
         * * Call this function to build a success toast (you can check the pict of success toast on github Readme.md)
         * * Example:
         * GDSCToast.buildSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can build an object of the toast so you can customize your own toast
         * * Example:
         * val successToast = GDSCToast.buildSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun buildSuccessToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
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
         * * Available since version 1.2.2
         * * buildSuccessToast with Context extension
         * * Example:
         * val successToast = this@TheActivity.apply{ buildSuccessToast("Hello this is success toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("buildSuccessToast-with-Context-extension")
        fun Context.buildSuccessToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildSuccessToast(this, text, duration, showLogo)

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
        fun showSuccessToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildSuccessToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.2
         * * showSuccessToast with Context extension
         * * Example:
         * this@TheActivity.apply{ showSuccessToast("Hello this is success toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("showSuccessToast-with-Context-extension")
        fun Context.showSuccessToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            showSuccessToast(this, text, duration, showLogo)

        /**
         * * Call this function to build a error toast (you can check the pict of error toast on github Readme.md)
         * * Example:
         * GDSCToast.buildErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can build an object of the toast so you can customize your own toast
         * * Example:
         * val errorToast = GDSCToast.buildErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun buildErrorToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
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
         * * Available since version 1.2.2
         * * buildErrorToast with Context extension
         * * Example:
         * val errorToast = this@TheActivity.apply{ buildErrorToast("Hello this is error toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("buildErrorToast-with-Context-extension")
        fun Context.buildErrorToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildErrorToast(this, text, duration, showLogo)

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
        fun showErrorToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildErrorToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.2
         * * showErrorToast with Context extension
         * * Example:
         * this@TheActivity.apply{ showErrorToast("Hello this is error toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("showErrorToast-with-Context-extension")
        fun Context.showErrorToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            showErrorToast(this, text, duration, showLogo)

        /**
         * * Call this function to build a warning toast (you can check the pict of warning toast on github Readme.md)
         * * Example:
         * GDSCToast.buildWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can build an object of the toast so you can customize your own toast
         * * Example:
         * val warningToast = GDSCToast.buildWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun buildWarningToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
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
         * * Available since version 1.2.2
         * * buildWarningToast with Context extension
         * * Example:
         * val warningToast = this@TheActivity.apply{ buildWarningToast("Hello this is warning toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("buildWarningToast-with-Context-extension")
        fun Context.buildWarningToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildWarningToast(this, text, duration, showLogo)

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
        fun showWarningToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildWarningToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.2
         * * showWarningToast with Context extension
         * * Example:
         * this@TheActivity.apply{ showWarningToast("Hello this is warning toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("showWarningToast-with-Context-extension")
        fun Context.showWarningToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            showWarningToast(this, text, duration, showLogo)

        /**
         * * Call this function to build a info toast (you can check the pict of info toast on github Readme.md)
         * * Example:
         * GDSCToast.buildInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true).show()
         * * Or you can build an object of the toast so you can customize your own toast
         * * Example:
         * val infoToast = GDSCToast.buildInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of the toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun buildInfoToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true): Toast {
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
         * * Available since version 1.2.2
         * * buildInfoToast with Context extension
         * * Example:
         * val infoToast = this@TheActivity.apply{ buildInfoToast("Hello this is info toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("buildInfoToast-with-Context-extension")
        fun Context.buildInfoToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildInfoToast(this, text, duration, showLogo)

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
        fun showInfoToast(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            buildInfoToast(context, text, duration, showLogo).show()

        /**
         * * Available since version 1.2.2
         * * showInfoToast with Context extension
         * * Example:
         * this@TheActivity.apply{ showInfoToast("Hello this is info toast", Toast.LENGTH_SHORT, true) }
         *
         * @param text to handle message that will shown from the toast
         * @param duration (optional) to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        @JvmName("showInfoToast-with-Context-extension")
        fun Context.showInfoToast(text: String, duration: Int = Toast.LENGTH_SHORT, showLogo: Boolean = true) =
            showInfoToast(this, text, duration, showLogo)

        /**
         * * Available since version 1.2.0
         * * Allow you to access configuration of GDSCToast
         * * Example:
         * GDSCToast.configOn(this)
         *
         * @param context to get context from activity or fragment
         */
        fun configOn(context: Context): GDSCToastConfig {
            return GDSCToastConfig(context)
        }

        /**
         * * Available since version 1.2.2
         * * configOn with Context Extension
         * * Example:
         * this@TheActivity.apply { configOn() }
         *
         */
        @JvmName("configOn-with-Context-extension")
        fun Context.configOn(): GDSCToastConfig {
            return GDSCToastConfig(this)
        }

        /**
         * * Available since version 1.2.1
         * * Allow you to use lambda expression to set up any properties that you need
         * * Example:
         * GDSCToast.showAnyToast(this@MainActivity) {
               it.apply {
                    text = "Hello this is from 1.2.1 ver"
                    duration = Toast.LENGTH_LONG
                    showLogo = false
                    toastShape = ToastShape.RECTANGLE
                    toastType = ToastType.ERROR
               }
         }
         *
         * @param context to get context from activity or fragment
         * @param block to configure some properties in configuration
         */
        inline fun showAnyToast(context: Context, block: (GDSCToastConfig) -> Unit) {
            val config = configOn(context)
            block(config)
            config.showToast()
        }

        /**
         * * Available since version 1.2.2
         * * showAnyToast with Context Extension
         * * Example:
         * this@TheActivity.apply { showAnyToast { } }
         *
         */
        @JvmName("showAnyToast-with-Context-extension")
        inline fun Context.showAnyToast(block: (GDSCToastConfig) -> Unit) {
            showAnyToast(this, block)
        }

        private fun buildToast(context: Context): GdscToastLayoutBinding =
            GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    }
}