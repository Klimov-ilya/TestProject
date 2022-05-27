package klimov.test.recipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import klimov.test.recipe.databinding.ItemRecipeBuildItemBinding
import klimov.test.recipe.entity.RecipeBuildFormatter

internal class RecipeBuildAdapter<T : RecipeBuildFormatter>(
    val onItemClick: (T) -> Unit
) : RecyclerView.Adapter<RecipeBuildAdapter<T>.RecipeBuildViewHolder>() {
    private val list = mutableListOf<T>()

    fun setData(data: List<T>) {
        with(list) {
            clear()
            addAll(data)
            notifyItemRangeChanged(0, list.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipeBuildViewHolder(
            ItemRecipeBuildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RecipeBuildViewHolder, position: Int) {
        holder.onBinding(list[position])
    }

    override fun getItemCount() = list.size

    inner class RecipeBuildViewHolder(binding: ItemRecipeBuildItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val checkBox: CheckBox = binding.recipeBuildCheckBox

        fun onBinding(item: T) {
            with(checkBox) {
                isChecked = item.getCheckedValue()
                text = item.getText()
                setOnClickListener { onItemClick.invoke(item) }
            }
        }
    }
}