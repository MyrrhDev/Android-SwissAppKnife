package helloworld.com.calclogfrags.API;

import helloworld.com.calclogfrags.Models.PuntPOST;
import helloworld.com.calclogfrags.Models.PuntuacionGlobal;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("puntuaciones")
    Call<PuntPOST> createPuntuaciones(@Body PuntPOST puntuacion);

    @GET("puntuaciones")
    Call<PuntuacionGlobal> getPuntuaciones();


}


