package klimov.test.testproject.recipe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import klimov.test.testproject.common.ApiStatus
import klimov.test.testproject.common.extensions.showElseGone
import klimov.test.testproject.common.ui.BaseFragment
import klimov.test.testproject.databinding.FragmentRecipeBinding
import klimov.test.testproject.recipe.api.request.Recipe
import klimov.test.testproject.recipe.entity.RecipeBuildEntity
import klimov.test.testproject.recipe.vm.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding>() {
    private val recipeViewModel: RecipeViewModel by viewModel()

    private lateinit var progress: ProgressBar
    private lateinit var errorTV: TextView

    private val adapter: RecipeAdapter by lazy { RecipeAdapter(itemClick) }

    private val itemClick = {
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentRecipeBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentRecipeBinding) {
        progress = binding.progressPb
        errorTV = binding.errorTV
    }

    override fun initViews(binding: FragmentRecipeBinding) {
        binding.recyclerRV.adapter = adapter
    }

    override fun initViewModels() {
        recipeViewModel.apiStatus.observe(viewLifecycleOwner) { status ->
            progress.showElseGone(status is ApiStatus.LoadingStatus<*>)
            errorTV.showElseGone(status is ApiStatus.ErrorStatus<*>)

            when (status) {
                is ApiStatus.LoadingStatus<*> -> Unit
                is ApiStatus.ErrorStatus<*> -> {
                    errorTV.text = status.errorMessage
                }
                is ApiStatus.SuccessStatus<List<Recipe>> -> {
                    //adapter.setData(status.data)
                }
            }
        }
        arguments?.let { args ->
            val entity = args.getParcelable(EXTRA_RECIPE_ENTITY) as? RecipeBuildEntity
            recipeViewModel.requestToGetRecipeList(entity)
        }
    }

    companion object {
        private const val EXTRA_RECIPE_ENTITY = "extra_recipe_entity"

        fun newInstance(recipeBuildEntity: RecipeBuildEntity) = RecipeFragment().apply {
            arguments = Bundle().apply { putParcelable(EXTRA_RECIPE_ENTITY, recipeBuildEntity) }
        }
    }
}