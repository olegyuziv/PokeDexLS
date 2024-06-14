package edu.url.salle.santiago.prieto.finalproject.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Controller.StoreC;
import edu.url.salle.santiago.prieto.finalproject.Controller.TrainerC;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.R;

public class TrainerV extends AppCompatActivity {


    private TrainerC trainerC;
    private LinearLayout pokeball;
    private LinearLayout superball;
    private LinearLayout ultraball;
    private LinearLayout masterball;
    private TextView title;
    private TextView moneyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainer);

        pokeball = findViewById(R.id.llPokeball);

        superball = findViewById(R.id.llSuperball);

        ultraball = findViewById(R.id.llUltraball);

        masterball = findViewById(R.id.llMasterball);

        title = findViewById(R.id.tvTrainerName);

        moneyTextView = findViewById(R.id.tvMoney);



        trainerC = new TrainerC(this);

        trainerC.loadTeam();
    }

    public void updateMoney(long money){
        moneyTextView.setText(money + " ₿");
    }
    public void showInfo(JSONObject jsonObject) {
        title.setText("Trainer " + trainerC.getUserName());

    }
}
