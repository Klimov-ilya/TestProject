package klimov.test.testproject.dashboard.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import klimov.test.testproject.common.ui.BaseFragment
import klimov.test.testproject.dashboard.vm.DashboardViewModel
import klimov.test.testproject.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    private val dashboardViewModel: DashboardViewModel by viewModel()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentDashboardBinding) {
    }

    override fun initViews(binding: FragmentDashboardBinding) {
        binding.recipeB.setOnClickListener {
            dashboardViewModel.navigateToRecipeBuild()
        }
    }

    override fun initViewModels() {
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }

}