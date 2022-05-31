package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import klimov.test.core.ui.BaseFragment
import klimov.test.recipe.databinding.FragmentRecipeFavouriteBinding

class RecipeFavouriteFragment : BaseFragment<FragmentRecipeFavouriteBinding>() {
    private val adapter = RecipeAdapter {
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRecipeFavouriteBinding.inflate(inflater, container, false)

    override fun initViews() {
        binding.favouriteRecipeListRV.adapter = this.adapter
    }

    override fun initSubscription() {
    }
}