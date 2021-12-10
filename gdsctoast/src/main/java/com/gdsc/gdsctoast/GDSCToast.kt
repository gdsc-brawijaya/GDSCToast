package com.gdsc.gdsctoast

/**
 * GDSCToast
 * Copyright (c) 2021 all rights reserved.
 * Created by Kylix Eza Saputra as Learning Development Android Google Developer Student Club University of Brawijaya
 * Contact me if you find any bugs or just want to collaborate in this project*/

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.gdsc.gdsctoast.databinding.GdscToastLayoutBinding

/**
 * Class that contains some toast functions
 */
class GDSCToast(private val context: Context): Toast(context) {

    companion object {

        /**
         * Call this function to make a normal toast (you can check the pict of normal toast on github Readme.md)
         * Example:
         * GDSCToast.makeNormalToast(context, "Hello this is normal toast", Toast.LENGTH_SHORT, true).show()
         * Or you can make an object of the toast so you can customize your own toast
         * Example:
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
                toastIdentifier.setBackgroundResource(R.drawable.toast_normal)
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
         * Shortcut if you just want to show the toast without any customization
         * Example:
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
         * Call this function to make a success toast (you can check the pict of success toast on github Readme.md)
         * Example:
         * GDSCToast.makeSuccessToast(context, "Hello this is success toast", Toast.LENGTH_SHORT, true).show()
         * Or you can make an object of the toast so you can customize your own toast
         * Example:
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
                toastIdentifier.setBackgroundResource(R.drawable.toast_success)
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.apply {
                    setImageResource(R.drawable.ic_success)
                    visibility = View.VISIBLE
                }
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * Shortcut if you just want to show the toast without any customization
         * Example:
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
         * Call this function to make a error toast (you can check the pict of error toast on github Readme.md)
         * Example:
         * GDSCToast.makeErrorToast(context, "Hello this is error toast", Toast.LENGTH_SHORT, true).show()
         * Or you can make an object of the toast so you can customize your own toast
         * Example:
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
                toastIdentifier.setBackgroundResource(R.drawable.toast_error)
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.apply {
                    setImageResource(R.drawable.ic_error)
                    visibility = View.VISIBLE
                }
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * Shortcut if you just want to show the toast without any customization
         * Example:
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
         * Call this function to make a warning toast (you can check the pict of warning toast on github Readme.md)
         * Example:
         * GDSCToast.makeWarningToast(context, "Hello this is warning toast", Toast.LENGTH_SHORT, true).show()
         * Or you can make an object of the toast so you can customize your own toast
         * Example:
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
                toastIdentifier.setBackgroundResource(R.drawable.toast_warning)
                if (showLogo)
                    ivGdscLogoDownside.visibility = View.VISIBLE
                else
                    ivGdscLogoDownside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.apply {
                    setImageResource(R.drawable.ic_warning)
                    visibility = View.VISIBLE
                }
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * Shortcut if you just want to show the toast without any customization
         * Example:
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
         * Call this function to make a info toast (you can check the pict of info toast on github Readme.md)
         * Example:
         * GDSCToast.makeInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true).show()
         * Or you can make an object of the toast so you can customize your own toast
         * Example:
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
                toastIdentifier.setBackgroundResource(R.drawable.toast_info)
                if (showLogo)
                    ivGdscLogoDownside.visibility = View.VISIBLE
                else
                    ivGdscLogoDownside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.apply {
                    setImageResource(R.drawable.ic_info)
                    visibility = View.VISIBLE
                }
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        /**
         * Shortcut if you just want to show the toast without any customization
         * Example:
         * GDSCToast.showInfoToast(context, "Hello this is info toast", Toast.LENGTH_SHORT, true)
         *
         * @param context to get context from activity or fragment
         * @param text to handle message that will shown from the toast
         * @param duration to control duration of your toast (LENGTH_LONG or LENGTH_SHORT)
         * @param showLogo(optional) to show/hide logo of Google Developer Student Club
         */
        fun showInfoToast(context: Context, text: String, duration: Int, showLogo: Boolean = true) =
            makeInfoToast(context, text, duration, showLogo).show()


        private fun buildToast(context: Context): GdscToastLayoutBinding =
            GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    }
}