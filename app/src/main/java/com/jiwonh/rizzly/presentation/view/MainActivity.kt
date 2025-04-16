package com.jiwonh.rizzly.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jiwonh.rizzly.domain.entity.PickupStyle
import com.jiwonh.rizzly.domain.entity.Tone
import com.jiwonh.rizzly.domain.entity.Vibe
import com.jiwonh.rizzly.presentation.viewmodel.RizzlyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RizzlyApp()
        }
    }
}

@Composable
@Preview
fun RizzlyApp(viewModel: RizzlyViewModel = hiltViewModel()) {
    var dmInput by remember { mutableStateOf("") }
    var messageInput by remember { mutableStateOf("") }
    var topicInput by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("💬 Generate DM Response")
        OutlinedTextField(dmInput, { dmInput = it }, label = { Text("Context") })
        Button(onClick = { viewModel.generateDmResponse(dmInput, Tone.FLIRTY) }) {
            Text("Get DM")
        }
        Text("AI: ${viewModel.dmResponse.collectAsState().value}")

        Spacer(modifier = Modifier.height(24.dp))

        Text("📸 Caption Wizard")
        Button(onClick = { viewModel.generateCaption(Vibe.TRENDY) }) {
            Text("Get Caption")
        }
        Text("AI: ${viewModel.caption.collectAsState().value}")

        Spacer(modifier = Modifier.height(24.dp))

        Text("🔥 Rizz Rating")
        OutlinedTextField(messageInput, { messageInput = it }, label = { Text("Your Message") })
        Button(onClick = { viewModel.rateAndRewriteText(messageInput) }) {
            Text("Rate Me")
        }
        viewModel.rizzRating.collectAsState().value?.let {
            Text("Score: ${it.score}")
            Text("Feedback: ${it.feedback}")
            Text("Suggestion: ${it.refinedVersion}")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("💘 Pickup Line Builder")
        OutlinedTextField(topicInput, { topicInput = it }, label = { Text("Topic") })
        Button(onClick = { viewModel.buildPickupLine(topicInput, PickupStyle.BOLD) }) {
            Text("Generate Pickup Line")
        }
        Text("AI: ${viewModel.pickupLine.collectAsState().value}")
    }
}
