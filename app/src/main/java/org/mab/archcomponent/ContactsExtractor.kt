package org.mab.archcomponent

import android.content.Context
import android.provider.ContactsContract

class ContactsExtractor {
    fun getContacts(context: Context): ArrayList<Contact> {
        val contacts = ArrayList<Contact>()
        val cur = context.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

        if (cur?.count ?: 0 > 0) {
            while (cur != null && cur.moveToNext()) {
                val id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    val pCur = context.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(id), null)
                    val numbers = ArrayList<String>()
                    while (pCur!!.moveToNext()) {
                        val phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER))
                        numbers.add(phoneNo)
//                        Log.i(TAG, "Name: $name")
//                        Log.i(TAG, "Phone Number: $phoneNo")
                    }
                    contacts.add(Contact(name, numbers))
                    pCur.close()
                }
            }
        }
        cur?.close()
        return contacts
    }
}