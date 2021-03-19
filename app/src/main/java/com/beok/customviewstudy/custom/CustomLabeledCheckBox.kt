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
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding =
        CustomLabeledCheckboxBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setupAttrs(context, attrs)
        setupListener()
    }

    private fun setupListener() {
        binding.clLabeledCheckbox.setOnClickListener {
            binding.cbLabeledCheckbox.isChecked = !binding.cbLabeledCheckbox.isChecked
        }
    }

    private fun setupAttrs(context: Context, attrs: AttributeSet?) {
        context
            .obtainStyledAttributes(attrs, R.styleable.CustomLabeledCheckBox)
            .run {
                binding.tvLabeledCheckbox.text = getString(R.styleable.CustomLabeledCheckBox_text)
                binding.cbLabeledCheckbox.isChecked =
                    getBoolean(R.styleable.CustomLabeledCheckBox_checked, false)
                recycle()
            }
    }
}