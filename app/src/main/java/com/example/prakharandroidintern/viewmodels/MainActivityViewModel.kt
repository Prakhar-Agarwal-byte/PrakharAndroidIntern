package com.example.prakharandroidintern.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.models.ExploreModal
import com.example.prakharandroidintern.models.TrendingModal

class MainActivityViewModel : ViewModel() {
    private val _exploreList = MutableLiveData(
        arrayListOf(
            ExploreModal(
                "Ellen Michelle",
                "Arc Vive Ltd, CEO",
                R.drawable.ic_baseline_person_24,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius rutrum risus vitae scelerisque. Cras varius sapien nec massa tempor, sit amet tincidunt erat laoreet. Phasellus egestas eu metus nec mollis. Maecenas vel nunc ac nisl interdum suscipit et nec ex. Integer id orci a dui ultricies rhoncus. Donec in risus sed nunc vehicula ultrices eu a lectus. Cras ultrices rutrum urna, a luctus nunc vehicula a.",
                listOf("startups", "covid-19", "lockdown")),
            ExploreModal(
                "Isaac Morgan",
                "Joe Pipes Ltd, HR",
                R.drawable.ic_baseline_person_24,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius rutrum risus vitae scelerisque. Cras varius sapien nec massa tempor, sit amet tincidunt erat laoreet. Phasellus egestas eu metus nec mollis. Maecenas vel nunc ac nisl interdum suscipit et nec ex. Integer id orci a dui ultricies rhoncus. Donec in risus sed nunc vehicula ultrices eu a lectus. Cras ultrices rutrum urna, a luctus nunc vehicula a.",
                listOf("startups", "covid-19", "lockdown")),
            ExploreModal(
                "Ellen Michelle",
                "Arc Vive Ltd, CEO",
                R.drawable.ic_baseline_person_24,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius rutrum risus vitae scelerisque. Cras varius sapien nec massa tempor, sit amet tincidunt erat laoreet. Phasellus egestas eu metus nec mollis. Maecenas vel nunc ac nisl interdum suscipit et nec ex. Integer id orci a dui ultricies rhoncus. Donec in risus sed nunc vehicula ultrices eu a lectus. Cras ultrices rutrum urna, a luctus nunc vehicula a.",
                listOf("startups", "covid-19", "lockdown")),
            ExploreModal(
                "Ellen Michelle",
                "Arc Vive Ltd, CEO",
                R.drawable.ic_baseline_person_24,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius rutrum risus vitae scelerisque. Cras varius sapien nec massa tempor, sit amet tincidunt erat laoreet. Phasellus egestas eu metus nec mollis. Maecenas vel nunc ac nisl interdum suscipit et nec ex. Integer id orci a dui ultricies rhoncus. Donec in risus sed nunc vehicula ultrices eu a lectus. Cras ultrices rutrum urna, a luctus nunc vehicula a.",
                listOf("startups", "covid-19", "lockdown")),
            ExploreModal(
                "Ellen Michelle",
                "Arc Vive Ltd, CEO",
                R.drawable.ic_baseline_person_24,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed varius rutrum risus vitae scelerisque. Cras varius sapien nec massa tempor, sit amet tincidunt erat laoreet. Phasellus egestas eu metus nec mollis. Maecenas vel nunc ac nisl interdum suscipit et nec ex. Integer id orci a dui ultricies rhoncus. Donec in risus sed nunc vehicula ultrices eu a lectus. Cras ultrices rutrum urna, a luctus nunc vehicula a.",
                listOf("startups", "covid-19", "lockdown")),

            )
        )

    val exploreList: LiveData<ArrayList<ExploreModal>> = _exploreList

    private val _savedList = MutableLiveData<ArrayList<ExploreModal>>(ArrayList())
    val savedList: LiveData<ArrayList<ExploreModal>> = _savedList

    fun addToSavedList(exploreModal: ExploreModal) {
        val list = _savedList.value!!
        list.add(exploreModal)
        _savedList.value = list
    }

    fun removeFromSavedList(position: Int) {
        val list = _savedList.value!!
        list.removeAt(position)
        _savedList.value = list
    }
}