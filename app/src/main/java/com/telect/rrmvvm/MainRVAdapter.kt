package com.telect.rrmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.telect.rrmvvm.model.ResponseItem

class MainRVAdapter(private var responseList: List<ResponseItem> = listOf()) :
    RecyclerView.Adapter<MainRVAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.tv_product_id)
        val title = itemView.findViewById<TextView>(R.id.tv_product_title)
        val productPrice = itemView.findViewById<TextView>(R.id.tv_product_price)
        val productDesc = itemView.findViewById<TextView>(R.id.tv_product_desc)

    }

    fun setData(responseList: List<ResponseItem>) {
        this.responseList = responseList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = responseList[position]
        holder.id.text = item.id.toString()
        holder.title.text = item.title.toString()
        holder.productPrice.text = item.price.toString()
        holder.productDesc.text = item.description.toString()

    }


    override fun getItemCount(): Int {
        return responseList.size
    }
}