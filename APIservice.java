package fpoly.nghiemtdph44856.asm1_ph44856_restapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservice {
     String DOMAIN ="http://192.168.64.102:3000/";
    @GET("/API/list")
    Call<List<Carmodel>> getCars();
}
