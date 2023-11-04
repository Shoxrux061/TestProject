package uz.isystem.testproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.isystem.testproject.R
import uz.isystem.testproject.data.room.ArticleRoomModel
import uz.isystem.testproject.databinding.ItemPizzaBinding

class CacheDessertAdapter:RecyclerView.Adapter<CacheDessertAdapter.ViewHolder>() {

    private val data = ArrayList<ArticleRoomModel>()

    fun setData(data:List<ArticleRoomModel>){
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding : ItemPizzaBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(data:ArticleRoomModel){
            binding.pizzaName.text = data.name
            binding.pizzaTitle.text = data.description
            binding.price.text = data.price.toString().plus("$")
            binding.image.load(data.img){
                placeholder(R.drawable.placeholder)
            }
            binding.pizzaName.isSelected = true
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}