package klimov.test.testproject.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import klimov.test.testproject.common.screens.Screens
import klimov.test.testproject.common.ui.BaseFragment
import klimov.test.testproject.databinding.FragmentRecipeBuildBinding
import klimov.test.testproject.recipe.entity.DietFormatter
import klimov.test.testproject.recipe.entity.MealFormatter
import klimov.test.testproject.recipe.vm.RecipeBuildViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeBuildFragment : BaseFragment<FragmentRecipeBuildBinding>() {
    private val recipeBuildViewModel: RecipeBuildViewModel by viewModel()
    private val mealAdapter = RecipeBuildAdapter<MealFormatter> { formatter ->
        recipeBuildViewModel.setMealData(formatter)
    }
    private val dietAdapter = RecipeBuildAdapter<DietFormatter> { formatter ->
        recipeBuildViewModel.setDietData(formatter)
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRecipeBuildBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentRecipeBuildBinding) {
    }

    override fun initViews(binding: FragmentRecipeBuildBinding) {
        binding.mealRV.adapter = mealAdapter
        binding.dietRV.adapter = dietAdapter
        binding.queryET.addTextChangedListener(
            onTextChanged = { text, _, _, _ -> recipeBuildViewModel.setQuery(text.toString()) }
        )
        binding.findRecipeB.setOnClickListener {
            val recipeBuildEntity = recipeBuildViewModel.getRecipeBuildEntity()
            navigateTo(Screens.RecipeScreen(recipeBuildEntity))
        }
    }

    override fun initViewModels() {
        recipeBuildViewModel.run {
            mealFormatterList.observe(viewLifecycleOwner) { mealFormatterList ->
                mealAdapter.setData(mealFormatterList)
            }
            dietFormatterList.observe(viewLifecycleOwner) { dietFormatterList ->
                dietAdapter.setData(dietFormatterList)
            }
        }
    }

    companion object {
        fun newInstance() = RecipeBuildFragment()
    }
}