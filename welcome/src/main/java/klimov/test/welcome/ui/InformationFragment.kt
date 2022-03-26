package klimov.test.welcome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.viewpager2.widget.ViewPager2
import klimov.test.core.ui.BaseFragment
import klimov.test.welcome.adapter.InformationPagerAdapter
import klimov.test.welcome.databinding.FragmentInformationBinding
import klimov.test.welcome.entity.stepResources

class InformationFragment : BaseFragment<FragmentInformationBinding>() {
    private lateinit var viewPager: ViewPager2
    private lateinit var progressViewPager: ProgressBar

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentInformationBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentInformationBinding) {
        viewPager = binding.pagerVP
        progressViewPager = binding.progressPB
    }

    override fun initViews(binding: FragmentInformationBinding) {
        viewPager.adapter = InformationPagerAdapter(
            stepResources,
            requireActivity()
        )
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val size = stepResources.size - 1
                val currentProgress = position / size.toDouble()
                progressViewPager.progress = (currentProgress * 100).toInt()
            }
        })
    }

    override fun initViewModels() {

    }

    companion object {
        fun getInstance() = InformationFragment()
    }

}