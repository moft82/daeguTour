package com.example.daegutour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecycleAdapter(private val context: Context)
    : RecyclerView.Adapter<RecycleAdapter.ViewHolder>(){
    var datas = mutableListOf<ListData>()
    interface OnItemClickListener{
        fun onItemClick(v:View, data: ListData, pos : Int)
    }

    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_layout, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.name)
        private val txtAddress: TextView = itemView.findViewById(R.id.address)
        private val imgProfile: ImageView = itemView.findViewById(R.id.img)

        fun bind(item:ListData) {
            txtName.text = item.name
            txtAddress.text = item.address
            Glide.with(itemView).load(item.img).into(imgProfile)

            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }
        }
    }

}