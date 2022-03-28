package klimov.test.dashboard.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import klimov.test.core.ui.BaseFragment
import klimov.test.dashboard.databinding.FragmentDashboardBinding
import klimov.test.dashboard.vm.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    private val dashboardViewModel: DashboardViewModel by viewModel()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun initViews() {
        binding.recipeB.setOnClickListener { dashboardViewModel.navigateToRecipeBuild() }
    }

    override fun initSubscription() {
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }

}