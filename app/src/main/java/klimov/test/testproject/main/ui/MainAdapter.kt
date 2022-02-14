package klimov.test.testproject.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import klimov.test.testproject.databinding.ItemMainHolderBinding
import klimov.test.testproject.main.entity.CharacterItem

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val items: MutableList<CharacterItem> = mutableListOf()

    fun setData(data: List<CharacterItem>) {
        with(items) {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(ItemMainHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class MainViewHolder(binding: ItemMainHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameTV = binding.nameTV

        fun bind(item: CharacterItem) {
            nameTV.text = item.name
        }
    }

}