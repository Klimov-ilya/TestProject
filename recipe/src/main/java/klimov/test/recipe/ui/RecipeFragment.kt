package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import klimov.test.ui.extension.showElseGone
import klimov.test.core.network.DataStatus
import klimov.test.core.ui.BaseFragment
import klimov.test.recipe.api.model.Recipe
import klimov.test.recipe.databinding.FragmentRecipeBinding
import klimov.test.recipe.entity.RecipeBuildEntity
import klimov.test.recipe.vm.RecipeViewModel
import klimov.test.ui.widgets.ErrorWidget
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding>() {
    private val recipeViewModel: RecipeViewModel by viewModel()
    private val adapter: RecipeAdapter by lazy { RecipeAdapter(itemClick) }

    private val itemClick = {
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentRecipeBinding.inflate(inflater, container, false)

    override fun initViews() {
        binding.recyclerRV.adapter = adapter
        binding.errorWidgetV.onButtonClick = { recipeViewModel.requestToGetRecipeList() }
    }

    override fun initSubscription() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                recipeViewModel.dataStatus.collect { status ->
                    binding.progressPb.showElseGone(status is DataStatus.LoadingStatus<*>)
                    binding.errorWidgetV.showElseGone(status is DataStatus.ErrorStatus<*>)

                    when (status) {
                        is DataStatus.LoadingStatus<*>, is DataStatus.InitStatus<*> -> Unit
                        is DataStatus.ErrorStatus<*> -> {
                            binding.errorWidgetV.setErrorText(status.errorMessage)
                        }
                        is DataStatus.SuccessStatus<List<Recipe>> -> {
                            adapter.setData(status.data)
                        }
                    }
                }
            }
        }
        arguments?.let { args ->
            val entity = args.getParcelable(EXTRA_RECIPE_ENTITY) as? RecipeBuildEntity
            recipeViewModel.setRecipeBuildEntity(entity)
            recipeViewModel.requestToGetRecipeList()
        }
    }

    companion object {
        const val EXTRA_RECIPE_ENTITY = "extra_recipe_entity"
    }
}