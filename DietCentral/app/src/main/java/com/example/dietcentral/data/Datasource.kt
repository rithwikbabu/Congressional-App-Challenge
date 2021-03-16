package com.example.dietcentral.data

import com.example.dietcentral.R
import com.example.dietcentral.model.recycledata

class Datasource {

    fun loadData(): List<recycledata> {
        return listOf<recycledata>(
            //remember to include empty string if no text is needed
            //Strings are in strings.xml and drawables/images are in resourcemanager
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo),
            recycledata(R.string.Title, R.drawable.dietcentrallogo)
        )
    }
}
