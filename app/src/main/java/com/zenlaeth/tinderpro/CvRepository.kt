package com.zenlaeth.tinderpro

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.zenlaeth.tinderpro.CvRepository.Singleton.cvList
import com.zenlaeth.tinderpro.CvRepository.Singleton.databaseRef

class CvRepository {
    object Singleton {
        // se connecter à la référence "cv"
        val databaseRef = FirebaseDatabase.getInstance().getReference("cvs");

        // créer une liste qui va contenir nos cv
        val cvList = arrayListOf<CvModel>()
    }

    fun updateData(callback: () -> Unit) {
        // absorber les données depuis la databaseRef -> liste de cv
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // retirer les anciennes
                cvList.clear()
                // recolter la liste
                for (ds in snapshot.children) {
                    // construire un objet cv
                    val cv = ds.getValue(CvModel::class.java)

                    // verifier que le cv n'est pas null
                    if (cv != null) {
                        cvList.add(cv)
                    }
                }
                // actionner le callback
                callback()
            }

            override fun onCancelled(p0: DatabaseError) {}

        })
    }

    // mettre à jour un cv dans la bdd
    fun updateCV(cv: CvModel) = databaseRef.child(cv.id).setValue(cv)
}