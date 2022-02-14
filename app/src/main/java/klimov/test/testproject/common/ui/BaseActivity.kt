package klimov.test.testproject.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    abstract fun getLayoutBinding() : T

    abstract fun findViews(binding: T)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = getLayoutBinding()
        setContentView(binding.root)
        findViews(binding)
    }

}