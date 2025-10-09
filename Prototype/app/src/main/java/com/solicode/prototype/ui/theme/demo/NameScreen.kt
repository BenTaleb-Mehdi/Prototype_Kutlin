package com.solicode.prototype.ui.theme.demo


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp



val persons = mutableStateListOf<Person>()

@Composable
fun Fiertname(){

    var text by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter a name ")},
                modifier = Modifier.weight(1f)

            )

            Button(
                onClick = {
                    var nameCl = text
                        .trim()
                        .replaceFirstChar { it.uppercase() }
                    if(nameCl.isNotBlank()){

                        persons.add(Person(nameCl))
                        text = " "
                    }
                }

            )

            {
                Text("Add name")
            }


        }


        persons.forEach { p ->
            Text("👤 ${p.name}", style = MaterialTheme.typography.bodyLarge)
        }

    }

}