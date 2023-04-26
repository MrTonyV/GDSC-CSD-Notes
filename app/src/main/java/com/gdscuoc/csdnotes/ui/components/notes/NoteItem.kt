package com.gdscuoc.csdnotes.ui.components.notes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscuoc.csdnotes.data.entities.NoteEntity

@Composable
fun NoteItem(modifier: Modifier = Modifier,noteEntity: NoteEntity) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(noteEntity.title, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(noteEntity.description)
        }
    }
}