package helloworld.com.calclogfrags.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.odysseus.imageflipper.ImageFlipper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import helloworld.com.calclogfrags.API.APIService;
import helloworld.com.calclogfrags.API.ApiUtils;
import helloworld.com.calclogfrags.Models.PuntPOST;
import helloworld.com.calclogfrags.Models.GamePoints;
import helloworld.com.calclogfrags.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Game extends Fragment {

    ImageFlipper imageFlipper;
    ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    Integer[] cardArray =  { 101, 102, 103 ,104, 105, 106, 107, 108, 109, 110, 111, 112, 113 ,114, 115, 116};

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    ImageButton firstBut, secondBut;

    int cardNumber = 1;
    double points = 0;

    Drawable arya;
    Drawable petyr;
    Drawable boar;
    Drawable cup;
    Drawable dickon;
    Drawable drogon;
    Drawable hounds;
    Drawable joffrey;
    Drawable oberyn;
    Drawable olly;
    Drawable ramsay;
    Drawable renly;
    Drawable robert;
    Drawable shadow;
    Drawable themountain;
    Drawable ygritte;

    BackgroundCount bc;
    TextView counter;

    public Game() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        //getActivity is a context in fragments
        imageFlipper = new ImageFlipper(getActivity());

        b1 = (ImageButton) v.findViewById(R.id.imageButton1);
        b2 = (ImageButton) v.findViewById(R.id.imageButton2);
        b3 = (ImageButton) v.findViewById(R.id.imageButton3);
        b4 = (ImageButton) v.findViewById(R.id.imageButton4);
        b5 = (ImageButton) v.findViewById(R.id.imageButton5);
        b6 = (ImageButton) v.findViewById(R.id.imageButton6);
        b7 = (ImageButton) v.findViewById(R.id.imageButton7);
        b8 = (ImageButton) v.findViewById(R.id.imageButton8);
        b9 = (ImageButton) v.findViewById(R.id.imageButton9);
        b10 = (ImageButton) v.findViewById(R.id.imageButton10);
        b11 = (ImageButton) v.findViewById(R.id.imageButton11);
        b12 = (ImageButton) v.findViewById(R.id.imageButton12);
        b13 = (ImageButton) v.findViewById(R.id.imageButton13);
        b14 = (ImageButton) v.findViewById(R.id.imageButton14);
        b15 = (ImageButton) v.findViewById(R.id.imageButton15);
        b16 = (ImageButton) v.findViewById(R.id.imageButton16);

        arya = getResources().getDrawable(R.drawable.arya);
        petyr = getResources().getDrawable(R.drawable.petyr);
        boar = getResources().getDrawable(R.drawable.boar);
        cup = getResources().getDrawable(R.drawable.cup);
        dickon = getResources().getDrawable(R.drawable.dickon);
        drogon = getResources().getDrawable(R.drawable.drogon);
        hounds = getResources().getDrawable(R.drawable.hounds);
        joffrey = getResources().getDrawable(R.drawable.joffrey);
        oberyn = getResources().getDrawable(R.drawable.oberyn);
        olly = getResources().getDrawable(R.drawable.olly);
        ramsay = getResources().getDrawable(R.drawable.ramsay);
        renly = getResources().getDrawable(R.drawable.renly);
        robert = getResources().getDrawable(R.drawable.robert);
        shadow = getResources().getDrawable(R.drawable.shadow);
        themountain = getResources().getDrawable(R.drawable.themountain);
        ygritte = getResources().getDrawable(R.drawable.ygritte);


        b1.setTag("0");
        b2.setTag("1");
        b3.setTag("2");
        b4.setTag("3");
        b5.setTag("4");
        b6.setTag("5");
        b7.setTag("6");
        b8.setTag("7");
        b9.setTag("8");
        b10.setTag("9");
        b11.setTag("10");
        b12.setTag("11");
        b13.setTag("12");
        b14.setTag("13");
        b15.setTag("14");
        b16.setTag("15");

        counter = (TextView) v.findViewById(R.id.countdown);
        bc = new BackgroundCount();
        bc.execute(100);

        Collections.shuffle(Arrays.asList(cardArray));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("101 listener", String.valueOf(thisCard));

                playTheCard(b1, thisCard);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b2, thisCard);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("101 listener", String.valueOf(thisCard));

                playTheCard(b3, thisCard);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b4, thisCard);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("101 listener", String.valueOf(thisCard));

                playTheCard(b5, thisCard);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b6, thisCard);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("101 listener", String.valueOf(thisCard));

                playTheCard(b7, thisCard);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b8, thisCard);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("101 listener", String.valueOf(thisCard));

                playTheCard(b9, thisCard);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b10, thisCard);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b11, thisCard);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b12, thisCard);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b13, thisCard);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b14, thisCard);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b15, thisCard);
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.v("102 listener", String.valueOf(thisCard));
                playTheCard(b16, thisCard);
            }
        });



        return v;
    }

    private void playTheCard(final ImageButton b, final int thisCard) {
        //Sets new image
        // without flippin
        /*if(cardArray[thisCard] == 101) {
            b.setImageResource(image101);
            Log.v("101 doStuff ", "101");
        } else if (cardArray[thisCard] == 102) {
            b.setImageResource(image102);
            Log.v("102 doStuff", "102");
        }*/
        //
        flipEmCards(b,thisCard);

        if(cardNumber == 1) {
            firstCard = cardArray[thisCard];
            cardNumber = 2;
            clickedFirst = thisCard;

            firstBut = b;

            Log.v("cardNumber", String.valueOf(firstCard));

            b.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardArray[thisCard];
            cardNumber = 1;
            clickedSecond = thisCard;

            secondBut = b;

            Log.v("cardNumber", String.valueOf(secondCard));

            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            b14.setEnabled(false);
            b15.setEnabled(false);
            b16.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Check if they go together
                    checkIfMatch(firstBut, secondBut);
                }
            }, 1000);

        }
    }

    private void flipEmCards(ImageButton b, int thisCard) {
        if(cardArray[thisCard] == 101) {
            imageFlipper.flipImage(arya, b);
            Log.v("101 flippni ", "101");
        } else if (cardArray[thisCard] == 102) {
            imageFlipper.flipImage(petyr, b);
            Log.v("102 flippni", "102");
        } else if (cardArray[thisCard] == 103) {
            imageFlipper.flipImage(boar, b);
        } else if (cardArray[thisCard] == 104) {
            imageFlipper.flipImage(cup, b);
        } else if (cardArray[thisCard] == 105) {
            imageFlipper.flipImage(dickon, b);
        } else if (cardArray[thisCard] == 106) {
            imageFlipper.flipImage(drogon, b);
        } else if (cardArray[thisCard] == 107) {
            imageFlipper.flipImage(hounds, b);
        } else if (cardArray[thisCard] == 108) {
            imageFlipper.flipImage(joffrey, b);
        } else if (cardArray[thisCard] == 109) {
            imageFlipper.flipImage(themountain, b);
        } else if (cardArray[thisCard] == 110) {
            imageFlipper.flipImage(ygritte, b);
        } else if (cardArray[thisCard] == 111) {
            imageFlipper.flipImage(oberyn, b);
        } else if (cardArray[thisCard] == 112) {
            imageFlipper.flipImage(olly, b);
        } else if (cardArray[thisCard] == 113) {
            imageFlipper.flipImage(ramsay, b);
        } else if (cardArray[thisCard] == 114) {
            imageFlipper.flipImage(renly, b);
        } else if (cardArray[thisCard] == 115) {
            imageFlipper.flipImage(robert, b);
        } else if (cardArray[thisCard] == 116) {
            imageFlipper.flipImage(shadow, b);
        }
    }

    private void checkIfMatch(ImageButton bf, ImageButton bs) {
        if(firstCard == 101 && secondCard == 102 || firstCard == 102 && secondCard == 101) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 103 && secondCard == 115 || firstCard == 115 && secondCard == 103) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 104 && secondCard == 108 || firstCard == 108 && secondCard == 104) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 105 && secondCard == 106 || firstCard == 106 && secondCard == 105) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 107 && secondCard == 113 || firstCard == 113 && secondCard == 107) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 109 && secondCard == 111 || firstCard == 111 && secondCard == 109) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 110 && secondCard == 112 || firstCard == 112 && secondCard == 110) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        } else if (firstCard == 114 && secondCard == 116 || firstCard == 116 && secondCard == 114) {
            bf.setVisibility(View.INVISIBLE);
            bs.setVisibility(View.INVISIBLE);
        }
        else { //reset 'em all
            b1.setImageResource(R.drawable.backcard);
            b2.setImageResource(R.drawable.backcard);
            b3.setImageResource(R.drawable.backcard);
            b4.setImageResource(R.drawable.backcard);
            b5.setImageResource(R.drawable.backcard);
            b6.setImageResource(R.drawable.backcard);
            b7.setImageResource(R.drawable.backcard);
            b8.setImageResource(R.drawable.backcard);
            b9.setImageResource(R.drawable.backcard);
            b10.setImageResource(R.drawable.backcard);
            b11.setImageResource(R.drawable.backcard);
            b12.setImageResource(R.drawable.backcard);
            b13.setImageResource(R.drawable.backcard);
            b14.setImageResource(R.drawable.backcard);
            b15.setImageResource(R.drawable.backcard);
            b16.setImageResource(R.drawable.backcard);
        }

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b13.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);

        checkEndGame();
    }

    private void checkEndGame() {
        if(b1.getVisibility() == View.INVISIBLE
                && b2.getVisibility() == View.INVISIBLE
                && b3.getVisibility() == View.INVISIBLE
                && b4.getVisibility() == View.INVISIBLE
                && b5.getVisibility() == View.INVISIBLE
                && b6.getVisibility() == View.INVISIBLE
                && b7.getVisibility() == View.INVISIBLE
                && b8.getVisibility() == View.INVISIBLE
                && b9.getVisibility() == View.INVISIBLE
                && b10.getVisibility() == View.INVISIBLE
                && b11.getVisibility() == View.INVISIBLE
                && b12.getVisibility() == View.INVISIBLE
                && b13.getVisibility() == View.INVISIBLE
                && b14.getVisibility() == View.INVISIBLE
                && b15.getVisibility() == View.INVISIBLE
                && b16.getVisibility() == View.INVISIBLE) {

            points = Double.parseDouble(counter.getText().toString());
            Log.v("points", String.valueOf(points));
            bc.cancel(true);
            if(bc.isCancelled()) counter.setText("0");

            String username = restoreUser();
            postEmPoints(username, points);

            AlertDialog.Builder alertDialogueBuilder = new AlertDialog.Builder(getActivity());
            alertDialogueBuilder.setMessage("Good Job!").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Fragment f = new Game();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container,f);
                    ft.commit();
                    dialog.dismiss();
                }
            }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogueBuilder.create();
            alertDialog.show();
        } else if(counter.getText().equals("0")){
            AlertDialog.Builder alertDialogueBuilder = new AlertDialog.Builder(getActivity());
            alertDialogueBuilder.setMessage("Game Over").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Fragment f = new Game();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container,f);
                    ft.commit();
                    dialog.dismiss();
                }
            }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogueBuilder.create();
            alertDialog.show();
        }
    }

    private class BackgroundCount extends AsyncTask<Integer,String,Integer> {
            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                counter.setText("0");
                checkEndGame();
            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
                counter.setText(values[0]);
            }

            @Override
            protected Integer doInBackground(Integer... integers) {
                Integer accumulation = 0;
                int i = integers[0];
                Log.v("integer", String.valueOf(i));
                while(i >= 0) {
                    accumulation += i;
                    publishProgress(String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    --i;
                }

                return accumulation;
            }
    }

    String restoreUser(){
        SharedPreferences sp = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);
        String user = sp.getString("username", " ");
        return user;
    }

    void postEmPoints(String user, double points) {
        APIService apiService = ApiUtils.getAPIService();

        GamePoints puntuacion = new GamePoints(points, user);
        PuntPOST p = new PuntPOST().setPuntuacion(puntuacion);
        p.setPuntuacion(puntuacion);

        Call<PuntPOST> call = apiService.createPuntuaciones(p);

        call.enqueue(new Callback<PuntPOST>() {
            @Override
            public void onResponse(Call<PuntPOST> call, Response<PuntPOST> response) {
                Log.v("onResponse", "onResponseonResponse");
                int statusCode = response.code();
                if (response.code() == 400) {
                    try {
                        Log.v("Error code 400",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(getContext().getApplicationContext(),"Success! User ID: "  , Toast.LENGTH_SHORT).show();




                Log.d("onResponse: json", String.valueOf(statusCode));


            }

            @Override
            public void onFailure(Call<PuntPOST> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(),"something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
