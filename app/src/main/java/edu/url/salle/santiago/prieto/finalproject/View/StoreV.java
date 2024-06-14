package edu.url.salle.santiago.prieto.finalproject.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Controller.StoreC;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.R;

public class StoreV extends AppCompatActivity {
    private StoreC storeC;
    private LinearLayout pokeball;
    private LinearLayout superball;
    private LinearLayout ultraball;
    private LinearLayout masterball;
    private TextView moneyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        pokeball = findViewById(R.id.llPokeball);

        superball = findViewById(R.id.llSuperball);

        ultraball = findViewById(R.id.llUltraball);

        masterball = findViewById(R.id.llMasterball);

        moneyTextView = findViewById(R.id.tvMoney);


        pokeball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeC.buyPokeball(Pokeball.PokeballType.POKEBALL);
            }
        });

        superball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeC.buyPokeball(Pokeball.PokeballType.SUPERBALL);
            }
        });
        ultraball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeC.buyPokeball(Pokeball.PokeballType.ULTRABALL);
            }
        });
        masterball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeC.buyPokeball(Pokeball.PokeballType.MASTERBALL);
            }
        });

        storeC = new StoreC(this);

        storeC.loadData();
    }

    public void updateMoney(long money){
        moneyTextView.setText(money + " ₿");
    }
    public void showInfo(JSONObject jsonObject) {
        moneyTextView.setText( storeC.getMoney() + " ₿");
        // set views based on the JSON object
        // updating the RecyclerView with new data
    }
}
