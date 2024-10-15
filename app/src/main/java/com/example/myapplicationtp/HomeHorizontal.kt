package com.example.myapplicationtp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationtp.ui.theme.MyBlue
import com.example.myapplicationtp.ui.theme.MyGrey


@Composable
fun HomeHorizontal(s: String) {

    Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Absolute.Center){
        BlocUn()
        BlocDeux()
    }

}
    @Composable
    fun BlocUn(){

        Column (
            verticalArrangement = Arrangement.Center){

        NomHorizontal()

        MaphotoHorizontal()
        Spacer(modifier= Modifier.height(20.dp))

        StatutHorizontal()
        Spacer(modifier= Modifier.height(20.dp))


        }
    }

@Composable
fun BlocDeux(){

    Column (Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center){

        FormationHorizontal()
        Spacer(modifier= Modifier.height(40.dp))

        MailHorizontal()
        //Spacer(modifier= Modifier.height(20.dp))

        LinkedinOneHorizontal()
        LinkedinTwoHorizontal()
        Spacer(modifier= Modifier.height(70.dp))

        DemarrerHorizontal()
        }

}



@Composable
fun NomHorizontal(){
    Text(
        text = "Maéva Desfours",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MyBlue,
        fontSize = 30.sp,
        modifier = Modifier.padding(30.dp)

    )
}


@Composable
fun MaphotoHorizontal() {

    Image(
        painterResource(id = R.drawable.ma_va_android),
        contentDescription = "photo de profil",
        modifier = Modifier.size(250.dp)
    )
}
@Composable
fun StatutHorizontal(){
    Text(
        text = "Etudiante en informatique pour la santé",
        //style = MaterialTheme.typography.titleLarge,
        color = MyGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
    )
}

@Composable
fun FormationHorizontal(){
    Text(
        text = "Ecole d'ingénieur ISIS - Castres",
        color = MyGrey,
    )
}

@Composable
fun MailHorizontal(){
    Text(
        text = "Mail : maeva.desfours@etud.univ-jfc.fr",
        color = MyBlue,

        )
}
@Composable
fun LinkedinOneHorizontal(){
    Text(
        text = "Linkedin: www.linkedin.com/in/maéva",
        color = MyBlue,)
}

@Composable
fun LinkedinTwoHorizontal(){
    Text(
        text = "desfours-b80bbb263",
        color = MyBlue,)
}
@Composable
fun DemarrerHorizontal() {
    Button(onClick = { /*action*/ }) {
        //Modifier.clickable(onClick = onClick),
        Text("Démarrer", fontWeight = FontWeight.Bold, fontSize = 30.sp,style = MaterialTheme.typography.bodyMedium)
    }
}

