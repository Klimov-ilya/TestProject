package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import klimov.test.core.ui.BaseFragment
import klimov.test.recipe.databinding.FragmentRecipeBuildBinding
import klimov.test.recipe.entity.DietFormatter
import klimov.test.recipe.entity.MealFormatter
import klimov.test.recipe.vm.RecipeBuildViewModel
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
            recipeBuildViewModel.navigateToRecipe()
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