package hr.unidu.kz.ocjenefilmova1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button oc;
    private RatingBar po;
    private int brojOcjena = 0;
    private float zbrojOcjena = 0.0f;
    private final int A1_OK_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oc = findViewById(R.id.ocijeni);
        po = findViewById(R.id.ratingBar);
        oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokreniDruguAktivnost();
            }
        });
    }
    private void pokreniDruguAktivnost(){
        Intent intent = new Intent(this, OcjenaActivity.class);
        intent.putExtra("naziv","android");
        startActivityForResult(intent,A1_OK_CODE);
    }
    // Ova metoda se automatski izvodi nakon što pozvana aktivnost završi izvođenje
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Provjerava je li druga aktivnost uspješno završila
        // Služi za identifikaciju određene aktivnosti
        if (requestCode == A1_OK_CODE) {
            if (resultCode == RESULT_OK) {
                // dohvaća podatke kojeje u poslani objekt tipa Intent dodala pozvana aktivnost
                zbrojOcjena += data.getFloatExtra("ocjena", 0.0f);
                brojOcjena++;
                float prosjek = zbrojOcjena/brojOcjena;
                po.setRating(prosjek);
            }
        }
    }
}
