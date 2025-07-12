package com.example.todoapp.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.ui.theme.MediumGrey

@Composable
fun EmptyContent(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(
               id = R.drawable.sentiment_very_dissatisfied,
            ),
            contentDescription = stringResource( id = R.string.empty_content),
            tint = MediumGrey
        )
        Text(
            text = stringResource(R.string.empty_content),
            color = MediumGrey,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
    }
}


@Composable
@Preview
fun EmptyContentPreview(){
    EmptyContent()
}