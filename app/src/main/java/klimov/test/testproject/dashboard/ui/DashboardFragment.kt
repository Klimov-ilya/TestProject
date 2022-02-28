package klimov.test.testproject.dashboard.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import klimov.test.testproject.common.navigation.screens.Screens
import klimov.test.testproject.common.ui.BaseFragment
import klimov.test.testproject.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentDashboardBinding) {
    }

    override fun initViews(binding: FragmentDashboardBinding) {
        binding.recipeB.setOnClickListener {
            navigateTo(Screens.RecipeBuildScreen())
        }
    }

    override fun initViewModels() {
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }

}