package fpoly.nghiemtdph44856.asm1_ph44856_restapi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView LVMain;
    List<Carmodel> listCarmodel;

    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LVMain=findViewById(R.id.listviewMain);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(APIservice.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice apIservice = retrofit.create(APIservice.class);
        Call<List<Carmodel>> call = apIservice.getCars();

        call.enqueue(new Callback<List<Carmodel>>() {
            @Override
            public void onResponse(Call<List<Carmodel>> call, Response<List<Carmodel>> response) {
                if (response.isSuccessful()) {
                     listCarmodel = response.body();

                     carAdapter = new CarAdapter(getApplicationContext(),listCarmodel);
                     LVMain.setAdapter(carAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Carmodel>> call, Throwable t) {

            }
        });
    }
}