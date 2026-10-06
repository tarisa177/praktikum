package com.example.myprofilee.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myprofilee.data.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(
            name = name
        )
    }

    fun updateBio(bio: String) {
        _uiState.value = _uiState.value.copy(
            bio = bio
        )
    }

    fun setEditing(editing: Boolean) {
        _uiState.value = _uiState.value.copy(
            isEditing = editing
        )
    }

    fun toggleDarkMode() {
        _uiState.value = _uiState.value.copy(
            isDarkMode = !_uiState.value.isDarkMode
        )
    }
}