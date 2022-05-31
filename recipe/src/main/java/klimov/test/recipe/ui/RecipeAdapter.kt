package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import klimov.test.recipe.databinding.ItemMainHolderBinding
import klimov.test.recipe.entity.Recipe

internal class RecipeAdapter(
    private val onItemClick: () -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private val items: MutableList<Recipe> = mutableListOf()

    fun setData(data: List<Recipe>) {
        with(items) {
            clear()
            addAll(data)
        }
        notifyItemRangeChanged(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipeViewHolder(ItemMainHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class RecipeViewHolder(binding: ItemMainHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameTV = binding.nameTV

        fun bind(recipe: Recipe) {
            nameTV.text = recipe.label

            itemView.setOnClickListener { onItemClick() }
        }
    }

}