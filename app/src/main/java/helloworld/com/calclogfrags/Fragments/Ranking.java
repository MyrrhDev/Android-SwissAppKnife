package helloworld.com.calclogfrags.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import helloworld.com.calclogfrags.API.APIService;
import helloworld.com.calclogfrags.API.ApiUtils;
import helloworld.com.calclogfrags.Models.PuntuacionGlobal;
import helloworld.com.calclogfrags.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends Fragment {

    ListView ranking;
    ListView scorelist;

    public Ranking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);
        ranking = (ListView) v.findViewById(R.id.ranking);
        scorelist = (ListView) v.findViewById(R.id.scorelist);
        getEmPoints();
        return v;
    }

    void getEmPoints() {
        APIService apiService = ApiUtils.getAPIService();
        Call<PuntuacionGlobal> call = apiService.getPuntuaciones();

        call.enqueue(new Callback<PuntuacionGlobal>() {
            @Override
            public void onResponse(Call<PuntuacionGlobal> call, Response<PuntuacionGlobal> response) {
                PuntuacionGlobal allPoints = response.body();

                allPoints.sortScores();

                String[] users = new String[allPoints.getSize()];
                Double[] points = new Double[allPoints.getSize()];

                String[] sPoints = new String[allPoints.getSize()];

                for (int i = 0; i < allPoints.getSize(); ++ i) {
                    users[i] = allPoints.position(i).getUsername();
                    points[i] = allPoints.position(i).getScore();

                    String line = users[i] + "                          " + String.valueOf(points[i]);

                    sPoints[i] = toString().valueOf(points[i]);

                    ranking.setAdapter(new ArrayAdapter<String>(
                            getContext().getApplicationContext(),R.layout.list_layout, R.id.textView,users
                    ));

                    scorelist.setAdapter(new ArrayAdapter<String>(
                            getContext().getApplicationContext(),R.layout.list_layout, R.id.textView2,sPoints
                    ));
                } //getContext().getApplicationContext(), android.R.layout.simple_list_item_1,all
            }

            @Override
            public void onFailure(Call<PuntuacionGlobal> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}