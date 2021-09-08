package com.wj.demoapp821.view.brewerydetails

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wj.demoapp821.R
import com.wj.demoapp821.utils.observeStateFlow
import com.wj.demoapp821.utils.setTextAndUpdateVisibility
import com.wj.demoapp821.view.main.MainViewModel
import com.wj.domain.model.Brewery
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BreweryDetailsFragment : Fragment(R.layout.brewery_details_fragment) {

    private val viewModel by sharedViewModel<MainViewModel>()

    private var breweryName: TextView? = null
    private var street: TextView? = null
    private var city: TextView? = null
    private var country: TextView? = null
    private var phone: TextView? = null
    private var websiteUrl: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        observeStateFlow(viewModel.breweryDetailsStateFlow) {
            it?.run { bindBrewery(it) }
        }
    }
    
    private fun initViews(view: View){
        view.run {
            breweryName = findViewById(R.id.breweryName)
            street = findViewById(R.id.street)
            city = findViewById(R.id.city)
            country = findViewById(R.id.country)
            phone = findViewById(R.id.phone)
            websiteUrl = findViewById(R.id.websiteUrl)
        }
        
    }

    private fun bindBrewery(brewery: Brewery){
        breweryName?.setTextAndUpdateVisibility(brewery.name)
        street?.setTextAndUpdateVisibility(brewery.street)
        city?.setTextAndUpdateVisibility(brewery.city)
        country?.setTextAndUpdateVisibility(brewery.country)
        phone?.setTextAndUpdateVisibility(brewery.phone)
        websiteUrl?.setTextAndUpdateVisibility(brewery.websiteUrl)
    }
}