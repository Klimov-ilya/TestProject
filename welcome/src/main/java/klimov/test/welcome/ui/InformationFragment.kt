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

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentInformationBinding.inflate(inflater, container, false)

    override fun initViews() {
        binding.pagerVP.adapter = InformationPagerAdapter(stepResources, requireActivity())

        binding.pagerVP.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val size = stepResources.size - 1
                val currentProgress = position / size.toDouble()
                binding.progressPB.progress = (currentProgress * 100).toInt()
            }
        })
    }

    override fun initSubscription() {
    }

    companion object {
        fun getInstance() = InformationFragment()
    }

}