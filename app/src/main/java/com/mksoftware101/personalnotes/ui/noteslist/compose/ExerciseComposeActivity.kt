package com.mksoftware101.personalnotes.ui.noteslist.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mksoftware101.personalnotes.R
import androidx.compose.ui.unit.dp
import com.mksoftware101.personalnotes.ui.noteslist.compose.ui.theme.PersonalNotesTheme

class ExerciseComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalNotesTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = "Just content description",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(text = message.author, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.message,
                    style = MaterialTheme.typography.body2,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")


@Preview
@Composable
fun PreviewMessageCard() {
    PersonalNotesTheme {
        Surface {
            MessageCard(Message("Vanessa Cook", "From here to Heaven"))
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(messages = SampleData.conversationSample)
}