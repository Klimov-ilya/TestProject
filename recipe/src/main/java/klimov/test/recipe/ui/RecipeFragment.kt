package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import klimov.test.core.extension.showElseGone
import klimov.test.core.network.ApiStatus
import klimov.test.core.ui.BaseFragment
import klimov.test.recipe.api.model.Recipe
import klimov.test.recipe.databinding.FragmentRecipeBinding
import klimov.test.recipe.entity.RecipeBuildEntity
import klimov.test.recipe.vm.RecipeViewModel
import klimov.test.ui.buttons.MainButton
import klimov.test.ui.widgets.ErrorWidget
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding>() {
    private val recipeViewModel: RecipeViewModel by viewModel()

    private lateinit var progress: ProgressBar
    private lateinit var errorWidget: ErrorWidget

    private val adapter: RecipeAdapter by lazy { RecipeAdapter(itemClick) }

    private val itemClick = {
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentRecipeBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentRecipeBinding) {
        progress = binding.progressPb
        errorWidget = binding.errorWidgetV
    }

    override fun initViews(binding: FragmentRecipeBinding) {
        binding.recyclerRV.adapter = adapter
        errorWidget.onButtonClick = { recipeViewModel.requestToGetRecipeList() }
    }

    override fun initViewModels() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                recipeViewModel.apiStatus.collect { status ->
                    progress.showElseGone(status is ApiStatus.LoadingStatus<*>)
                    errorWidget.showElseGone(status is ApiStatus.ErrorStatus<*>)

                    when (status) {
                        is ApiStatus.LoadingStatus<*>, is ApiStatus.InitStatus<*> -> Unit
                        is ApiStatus.ErrorStatus<*> -> {
                            errorWidget.setErrorText(status.errorMessage)
                        }
                        is ApiStatus.SuccessStatus<List<Recipe>> -> {
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