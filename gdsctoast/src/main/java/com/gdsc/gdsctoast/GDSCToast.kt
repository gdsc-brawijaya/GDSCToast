package com.gdsc.gdsctoast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.gdsc.gdsctoast.databinding.GdscToastLayoutBinding

class GDSCToast(private val context: Context): Toast(context) {

    companion object {

        fun showNormalText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.setBackgroundResource(R.drawable.toast_normal)
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                tvInformation.setTextColor(context.resources.getColor(R.color.black))
                ivCondition.visibility = View.GONE
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        fun showSuccessText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
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

        fun showErrorText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
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

        fun showWarningText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
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

        fun showInfoText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
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


        private fun buildToast(context: Context): GdscToastLayoutBinding =
            GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    }
}