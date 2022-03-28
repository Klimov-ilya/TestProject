package klimov.test.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    protected val navigationHolder: NavigatorHolder by inject()

    abstract val binding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}