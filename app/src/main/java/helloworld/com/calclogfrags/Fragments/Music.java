package helloworld.com.calclogfrags.Fragments;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;

import java.io.File;
import java.util.ArrayList;

import helloworld.com.calclogfrags.R;


public class Music extends Fragment implements View.OnClickListener {

    //private OnFragmentInteractionListener mListener;

    ImageView backimage;
    ListView songList;
    ImageButton play;
    ImageButton next;
    ImageButton forward;
    ImageButton rewind;
    ImageButton back;
    SeekBar seekBar;

    String[] songNames;
    MediaPlayer mp;
    ArrayList <File> Songs;
    int posSong;
    Uri u;
    Thread updateSeekBar;

    public Music() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_music, container, false);

        backimage = (ImageView) v.findViewById(R.id.backimage);
        songList = (ListView) v.findViewById(R.id.songlist);
        play = (ImageButton) v.findViewById(R.id.play);
        forward = (ImageButton) v.findViewById(R.id.forward);
        next = (ImageButton) v.findViewById(R.id.next);
        rewind = (ImageButton) v.findViewById(R.id.rewind);
        back = (ImageButton) v.findViewById(R.id.back);
        seekBar = (SeekBar) v.findViewById(R.id.seekBar);

        play.setOnClickListener(this);
        forward.setOnClickListener(this);
        next.setOnClickListener(this);
        rewind.setOnClickListener(this);
        back.setOnClickListener(this);

        Log.v("aftercreating things", "after");

        updateSeekBar = new Thread() {
            @Override public void run() {
                int totesDuration = mp.getDuration();
                int currentPos = 0;
                while (currentPos < totesDuration) {
                    try {
                        sleep(500);
                        currentPos = mp.getCurrentPosition();
                        seekBar.setProgress(currentPos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        if(mp != null) {
            mp.stop();
            mp.release();
        }

        Songs = findAllSongs(Environment.getExternalStorageDirectory());
        //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)

        songNames = new String[ Songs.size()];
        for(int i = 0; i < Songs.size(); ++i) {
            songNames[i] = Songs.get(i).getName().toString().replace(".mp3","");
        }
        Log.v("Songs", "Songs");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getContext().getApplicationContext(),android.R.layout.simple_list_item_1,songNames);
        songList.setAdapter(listAdapter);
        Log.v("songList", "songList");

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //play
                    u = Uri.parse(Songs.get(position).toString());
                    posSong = position;

                    mp = MediaPlayer.create(getContext().getApplicationContext(),u);
                    mp.start();


                    seekBar.setMax(mp.getDuration());

                    updateSeekBar.start();

                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            mp.seekTo(seekBar.getProgress());

                        }
                    });

                }
        });

        Log.v("onCreateView", "onCreateView onCreateView");
        return v;
    }




    public ArrayList <File> findAllSongs(File root) {
        Log.v("findAllSongs", "findAllSongs findAllSongs");
        ArrayList <File> slist = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if(singleFile.isDirectory() && !singleFile.isHidden()) {
                slist.addAll(findAllSongs(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(".mp3")) {
                    slist.add(singleFile);
                }
            }
        }
        return slist;
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.play:
                if(mp.isPlaying()) {
                    mp.pause();
                }
                else mp.start();
                break;
            case R.id.forward:
                mp.seekTo(mp.getCurrentPosition()+5000);
                break;
            case R.id.rewind:
                mp.seekTo(mp.getCurrentPosition()-5000);
                break;
            case R.id.next:
                mp.stop();
                mp.release();
                posSong = (posSong+1)%Songs.size();
                u = Uri.parse(Songs.get(posSong).toString());
                mp = MediaPlayer.create(getContext().getApplicationContext(),u);
                seekBar.setMax(mp.getDuration());
                mp.start();
                break;
            case R.id.back:
                mp.stop();
                mp.release();
                if(posSong-1 < 0) {
                    posSong = Songs.size()-1;
                }
                else {
                    posSong = posSong - 1;
                }
                u = Uri.parse(Songs.get(posSong).toString());
                mp = MediaPlayer.create(getContext().getApplicationContext(),u);
                seekBar.setMax(mp.getDuration());
                mp.start();
                break;
        }
    }
}
