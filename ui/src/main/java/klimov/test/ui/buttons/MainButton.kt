package klimov.test.ui.buttons

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
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

    private lateinit var mainTV: TextView

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MainButton)

        findViews()
        acceptAttrs(attributes)
        binding.containerCV.setOnClickListener { onClick?.invoke() }
    }

    fun setButtonText(textResId: Int) {
        mainTV.text = context.getText(textResId)
    }

    fun setButtonText(text: String) {
        mainTV.text = text
    }

    private fun findViews() {
        mainTV = binding.mainTV
    }

    private fun acceptAttrs(attributes: TypedArray) {
        val textColorRes = attributes.getInt(R.styleable.MainButton_android_textColor, R.color.system_black)
        mainTV.text = attributes.getString(R.styleable.MainButton_android_text)
        mainTV.setTextColor(textColorRes)

        val backgroundRes = attributes.getInt(R.styleable.MainButton_android_background, R.color.system_white)
        binding.containerCV.setCardBackgroundColor(backgroundRes)
    }

}