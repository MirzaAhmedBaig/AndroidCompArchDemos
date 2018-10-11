package org.mab.archcomponent

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CustomLifecycleActivity : AppCompatActivity() {

    private val contactsViewModel by lazy {
        ViewModelProviders.of(this).get(ContactsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_lifecycle)
        subscribeToDataChannel()
    }

    private fun subscribeToDataChannel() {
        contactsViewModel.getContactsLiveData().observe(this, Observer<ArrayList<Contact>> {

        })
    }
}
