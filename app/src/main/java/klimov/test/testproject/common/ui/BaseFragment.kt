package klimov.test.testproject.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import klimov.test.testproject.App
import org.koin.android.ext.android.inject

abstract class BaseFragment <T : ViewBinding> : Fragment() {
    private var binding: T? = null

    abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?) : T

    abstract fun findViews(binding: T)
    abstract fun initViews(binding: T)
    abstract fun initViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getBinding(inflater, container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            findViews(it)
            initViews(it)
            initViewModels()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}