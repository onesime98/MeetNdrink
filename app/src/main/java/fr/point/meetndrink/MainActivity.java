package fr.point.meetndrink;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView bars, profil, amis, parametres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bars = findViewById(R.id.imageview_bars);
        profil = findViewById(R.id.imageview_profil);
        amis = findViewById(R.id.imageview_friends);
        parametres = findViewById(R.id.imageview_settings);

        //Action du clic sur le bouton bar à écrire
        bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Action du clic sur le bouton profil à écrire

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Action du clic sur le bouton amis à écrire

        amis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Action du clic sur le bouton paramètres à écrire

        parametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
