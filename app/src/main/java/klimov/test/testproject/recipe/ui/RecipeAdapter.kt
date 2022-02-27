package klimov.test.testproject.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import klimov.test.testproject.databinding.ItemMainHolderBinding

class RecipeAdapter(
    private val onItemClick: () -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private val items: MutableList<String> = mutableListOf()

    fun setData(data: List<String>) {
        with(items) {
            clear()
            addAll(data)
        }
        notifyItemChanged(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipeViewHolder(ItemMainHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class RecipeViewHolder(binding: ItemMainHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameTV = binding.nameTV

        fun bind(item: String) {
            nameTV.text = item

            itemView.setOnClickListener { onItemClick() }
        }
    }

}