package hr.unidu.kz.ocjenefilmova1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;

public class OcjenaActivity extends AppCompatActivity {
    private RatingBar po;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocjena);
        po = findViewById(R.id.ocjena);
        po.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                vratiOcjenu();
            }
        });
    }
    private void vratiOcjenu(){
        float oc = po.getRating();
        Intent i = new Intent();
        i.putExtra("ocjena", oc);
        // Sve je Ok
        setResult(RESULT_OK, i);
        // završetak - potvrda
        finish();
    }
}
