package org.mab.archcomponent

import android.app.Application
import android.arch.lifecycle.*

class ContactsViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {
    private val contactsLiveData = MutableLiveData<ArrayList<Contact>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        contactsLiveData.value = ContactsExtractor().getContacts(getApplication<Application>().baseContext!!)
    }

    fun getContactsLiveData(): MutableLiveData<ArrayList<Contact>> {
        return contactsLiveData
    }
}
