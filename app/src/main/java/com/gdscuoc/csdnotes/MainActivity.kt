package com.gdscuoc.csdnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.gdscuoc.csdnotes.data.db.AppDatabase
import com.gdscuoc.csdnotes.data.entities.NoteEntity
import com.gdscuoc.csdnotes.data.repositories.NotesRepository
import com.gdscuoc.csdnotes.ui.navigation.MainNavHost
import com.gdscuoc.csdnotes.ui.theme.CsdNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CsdNotesTheme {
                MainNavHost()
            }
        }
    }
}