package com.ovkoc.cavit.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ovkoc.cavit.R
import com.ovkoc.cavit.ui.home.model.CountryUIModel
import com.squareup.picasso.Picasso

class CountriesRecyclerViewAdapter :
    RecyclerView.Adapter<CountriesRecyclerViewAdapter.CountriesViewHolder>() {

    private var dataSet = mutableListOf<CountryUIModel>()
    var onItemClick: ((item: CountryUIModel) -> Unit)? = null

    fun setData(data: List<CountryUIModel>) {
        dataSet = data.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val contentView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.country_item,
                parent,
                false
            )

        return CountriesViewHolder(contentView)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bindView(dataSet[position])
    }


    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val countryNameTextView: TextView = itemView.findViewById(R.id.countryNameTV)
        private val countryFlagImageView: ImageView = itemView.findViewById(R.id.countryFlagIV)
        private val caseTextView: TextView = itemView.findViewById(R.id.caseTV)
        private val activeCaseTextView: TextView = itemView.findViewById(R.id.activeCaseTV)
        private val deathNumberTextView: TextView = itemView.findViewById(R.id.deathTV)
        private val recoveredTextView: TextView = itemView.findViewById(R.id.recoveredCaseTV)


        fun bindView(item: CountryUIModel) {

            Picasso.get().load(item.flagImageUrl ?: "null")
                .into(countryFlagImageView)

            countryNameTextView.text = item.country
            caseTextView.text = item.cases.toString()
            activeCaseTextView.text = item.active.toString()
            deathNumberTextView.text = item.deaths.toString()
            recoveredTextView.text = item.recovered.toString()


            itemView.setOnClickListener { onItemClick?.invoke(item) }
        }
    }


}