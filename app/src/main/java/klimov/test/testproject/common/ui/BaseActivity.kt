package klimov.test.testproject.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    protected val navigationHolder: NavigatorHolder by inject()

    abstract fun getLayoutBinding() : T

    abstract fun findViews(binding: T)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = getLayoutBinding()
        setContentView(binding.root)
        findViews(binding)
    }

}