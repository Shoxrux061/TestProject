package uz.isystem.testproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.isystem.testproject.data.models.dessert_list.DesertListItem
import uz.isystem.testproject.data.room.ArticleRoomModel
import uz.isystem.testproject.data.room.PizzaRoomModel
import uz.isystem.testproject.databinding.ItemPizzaBinding

class CachePizzaAdapter:RecyclerView.Adapter<CachePizzaAdapter.ViewHolder>() {

    private val data = ArrayList<PizzaRoomModel>()

    fun setData(data:List<PizzaRoomModel>){
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding : ItemPizzaBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(data:PizzaRoomModel){
            binding.pizzaName.text = data.name
            binding.pizzaTitle.text = data.description
            binding.price.text = data.price.toString().plus("$")
            binding.image.load(data.img)
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