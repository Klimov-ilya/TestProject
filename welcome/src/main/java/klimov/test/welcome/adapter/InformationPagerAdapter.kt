package klimov.test.welcome.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import klimov.test.welcome.entity.InformationResources
import klimov.test.welcome.ui.InformationStepFragment

class InformationPagerAdapter(
    private val resources: List<InformationResources>,
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = resources.size

    override fun createFragment(position: Int) =
        InformationStepFragment.getInstance(
            resources[position].title,
            resources[position].text,
            position == resources.size - 1
        )
}