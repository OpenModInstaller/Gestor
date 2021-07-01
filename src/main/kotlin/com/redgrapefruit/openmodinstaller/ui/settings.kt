package com.redgrapefruit.openmodinstaller.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.sun.security.auth.module.NTSystem

private val ntSystem = NTSystem()

@Composable
fun createSettings(enabled: Boolean) {
    if (!enabled) return

    var modsFolderField by remember { mutableStateOf(Properties.modsFolderField) }
    var cacheFolderField by remember { mutableStateOf(Properties.cacheFolderField) }
    var useUnverifiedSources by remember { mutableStateOf(Properties.useUnverifiedSources) }
    var storeCaches by remember { mutableStateOf(Properties.storeCaches) }
    var useAutocomplete by remember { mutableStateOf(Properties.useAutocomplete) }

    Column(modifier = Modifier.padding(40.dp, 75.dp)) {
        Row {
            // Mods folder
            // Label
            Text(
                text = "Mods folder: ",
                fontSize = 1.4.em,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
            // Text Area
            TextField(
                value = modsFolderField,
                onValueChange = { new -> modsFolderField = new; Properties.modsFolderField = new },
                textStyle = TextStyle(fontSize = 1.2.em)
            )
        }
        Row(modifier = Modifier.padding(0.dp, 20.dp)) {
            // Cache folder
            // Label
            Text(
                text = "Cache folder: ",
                fontSize = 1.4.em,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
            // Text Area
            TextField(
                value = cacheFolderField,
                onValueChange = { new -> cacheFolderField = new; Properties.cacheFolderField = new },
                textStyle = TextStyle(fontSize = 1.2.em)
            )
        }
        Row {
            // Use unverified distributions
            // Label
            Text(
                text = "Use unverified distributions: ",
                fontSize = 1.4.em,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
            // Button
            Checkbox(
                checked = useUnverifiedSources,
                onCheckedChange = { new -> useUnverifiedSources = new; Properties.useUnverifiedSources = new },
                modifier = Modifier.padding(10.dp, 20.dp)
            )
        }
        Row {
            // Use NIO API to shorten download times
            // Label
            Text(
                text = "Store cache: ",
                fontSize = 1.4.em,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
            // Button
            Checkbox(
                checked = storeCaches,
                onCheckedChange = { new -> storeCaches = new; Properties.storeCaches = new },
                modifier = Modifier.padding(10.dp, 20.dp)
            )
        }
        Row {
            // Use autocomplete
            // Label
            Text(
                text = "Use autocompletion: ",
                fontSize = 1.4.em,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
            // Button
            Checkbox(
                checked = useAutocomplete,
                onCheckedChange = { new -> useAutocomplete = new; Properties.useAutocomplete = new },
                modifier = Modifier.padding(10.dp, 20.dp)
            )
        }
    }
}