package br.com.somdosanimais;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView dogView;
    private ImageView catView;
    private ImageView leonView;
    private ImageView monkeyView;
    private ImageView sheepView;
    private ImageView cowView;
    private MediaPlayer mediaPlayerAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setClickListeners();

    }

    private void setViews(){
        dogView = findViewById(R.id.idDog);
        catView = findViewById(R.id.idCat);
        leonView = findViewById(R.id.idLeon);
        monkeyView = findViewById(R.id.idMonkey);
        sheepView = findViewById(R.id.idSheep);
        cowView = findViewById(R.id.idCow);
    }

    @Override
    public void onClick(View v) {

        switch ( v.getId()){
            case R.id.idDog:
            mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.cao);
            playSong();
            break;
            case R.id.idCat:
                mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.gato);
                playSong();
                break;
            case R.id.idLeon:
                mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.leao);
                playSong();
                break;
            case R.id.idMonkey:
                mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.macaco);
                playSong();
                break;
            case R.id.idSheep:
                mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.ovelha);
                playSong();
                break;
            case R.id.idCow:
                mediaPlayerAnimals = MediaPlayer.create(MainActivity.this,R.raw.vaca);
                playSong();
                break;
        }
    }

    private void playSong(){
        if(mediaPlayerAnimals != null ){
            mediaPlayerAnimals.start();

        }
    }

    private void setClickListeners(){
        dogView.setOnClickListener(this);
        catView.setOnClickListener(this);
        leonView.setOnClickListener(this);
        monkeyView.setOnClickListener(this);
        sheepView.setOnClickListener(this);
        cowView.setOnClickListener(this);

    }

    //removendo os rescurso utilizados.

    @Override
    protected void onDestroy(){
        if(mediaPlayerAnimals != null){
            mediaPlayerAnimals.release();
            mediaPlayerAnimals = null;

        }
        super.onDestroy();
    }
}
