package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import klimov.test.core.ui.BaseFragment
import klimov.test.recipe.databinding.FragmentRecipeBuildBinding
import klimov.test.recipe.entity.DietFormatter
import klimov.test.recipe.entity.MealFormatter
import klimov.test.recipe.vm.RecipeBuildViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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

    override fun initViews() {
        binding.mealRV.adapter = mealAdapter
        binding.dietRV.adapter = dietAdapter
        binding.queryET.addTextChangedListener(
            onTextChanged = { text, _, _, _ -> recipeBuildViewModel.setQuery(text.toString()) }
        )
        binding.findRecipeB.setOnClickListener {
            recipeBuildViewModel.navigateToRecipe()
        }
    }

    override fun initSubscription() {
        viewLifecycleOwner.lifecycleScope.launch {
            recipeBuildViewModel.mealFormatterFlow.collect { mealFormatterList ->
                mealAdapter.setData(mealFormatterList)
            }
            recipeBuildViewModel.dietFormatterFlow.collect { dietFormatterList ->
                dietAdapter.setData(dietFormatterList)
            }
        }
    }

    companion object {
        fun newInstance() = RecipeBuildFragment()
    }
}