package com.ferechamitbeyli.ordermanagementmvvm.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ferechamitbeyli.ordermanagementmvvm.databinding.ItemOrderLayoutBinding
import com.ferechamitbeyli.ordermanagementmvvm.model.Order

class OrderAdapter(private val orders: ArrayList<Order>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    fun updateOrders(newOrders: List<Order>) {
        orders.clear()
        orders.addAll(newOrders)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int = orders.size

    inner class ViewHolder(val binding: ItemOrderLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.orderIdTv.text = order.id.toString()
            binding.productNameTv.text = order.product.toString()
            binding.userNameTv.text = order.user.name.toString()
        }
    }
}