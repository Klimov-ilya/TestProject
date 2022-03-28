package klimov.test.ui.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import klimov.test.ui.R
import klimov.test.ui.buttons.MainButton
import klimov.test.ui.databinding.WidgetErrorBinding

class ErrorWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {
    var onButtonClick: (() -> Unit)? = null

    private val binding = WidgetErrorBinding.inflate(LayoutInflater.from(context), this, true)

    private lateinit var errorTV: TextView
    private lateinit var errorB: MainButton

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MainButton)

        findViews()
        acceptAttrs(attributes)

        errorB.onClick = onButtonClick
    }

    fun setErrorText(errorTextResId: Int) {
        errorTV.text = context.getText(errorTextResId)
    }

    fun setErrorText(errorText: String?) {
        errorTV.text = errorText
    }

    private fun findViews() {
        errorTV = binding.errorTV
        errorB = binding.retryB
    }

    private fun acceptAttrs(attrs: TypedArray) {
        errorTV.text = attrs.getString(R.styleable.ErrorWidget_android_text) ?: context.getText(R.string.error_default)

        val buttonErrorText = attrs.getString(R.styleable.ErrorWidget_errorButtonText) ?: context.getText(R.string.retry)
        errorB.setButtonText(buttonErrorText.toString())
    }

}