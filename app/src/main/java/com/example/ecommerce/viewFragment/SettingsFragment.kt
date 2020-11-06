package com.example.ecommerce.viewFragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.ecommerce.R

class SettingsFragment : PreferenceFragmentCompat() {



    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }


}
