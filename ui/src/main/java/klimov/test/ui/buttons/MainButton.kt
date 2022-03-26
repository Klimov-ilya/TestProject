package klimov.test.ui.buttons

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import klimov.test.ui.R
import klimov.test.ui.databinding.ButtonMainBinding

class MainButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle) {
    var onClick: (() -> Unit)? = null

    private val binding = ButtonMainBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MainButton)

        val textColorRes = attributes.getInt(R.styleable.MainButton_android_textColor, R.color.system_black)
        binding.mainTV.text = attributes.getString(R.styleable.MainButton_android_text)
        binding.mainTV.setTextColor(textColorRes)

        val backgroundRes = attributes.getInt(R.styleable.MainButton_android_background, R.color.system_white)
        binding.containerCV.setCardBackgroundColor(backgroundRes)
        binding.containerCV.setOnClickListener { onClick?.invoke() }
    }

}