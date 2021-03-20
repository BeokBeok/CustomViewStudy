package com.beok.customviewstudy.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.beok.customviewstudy.R
import com.beok.customviewstudy.databinding.CustomLabeledCheckboxBinding

class CustomLabeledCheckBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = R.attr.customLabeledCheckBoxStyle
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding =
        CustomLabeledCheckboxBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setupAttrs(context, attrs, defStyleAttr)
        setupListener()
    }

    private fun setupListener() {
        binding.clLabeledCheckbox.setOnClickListener {
            binding.cbLabeledCheckbox.isChecked = !binding.cbLabeledCheckbox.isChecked
        }
    }

    private fun setupAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        context
            .obtainStyledAttributes(
                attrs,
                R.styleable.CustomLabeledCheckBox,
                defStyleAttr,
                R.style.CustomLabeledCheckBoxStyle
            )
            .run {
                binding.tvLabeledCheckbox.text =
                    getString(R.styleable.CustomLabeledCheckBox_android_text)
                binding.cbLabeledCheckbox.isChecked =
                    getBoolean(R.styleable.CustomLabeledCheckBox_android_checked, false)
                recycle()
            }
    }
}