package com.example.myprofilee

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofilee.ui.ProfileScreen
import com.example.myprofilee.viewmodel.ProfileViewModel

@Composable
fun App() {

    val viewModel: ProfileViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()

    val colorScheme = if (uiState.isDarkMode) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme
    ) {

        ProfileScreen(
            uiState = uiState,

            onNameChange = {
                viewModel.updateName(it)
            },

            onBioChange = {
                viewModel.updateBio(it)
            },

            onEditClick = {
                viewModel.setEditing(true)
            },

            onSaveClick = {
                viewModel.setEditing(false)
            },

            onDarkModeChange = {
                viewModel.toggleDarkMode()
            }
        )
    }
}