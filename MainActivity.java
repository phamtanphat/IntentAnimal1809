package khoapham.ptp.phamtanphat.intentanimal;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinhgoc,imgHinhchon;
    static String[] manghinh;
    int valuehinhgoc = 0;
    int Request_Code_Image =12;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        event();
        click();
    }

    private void click() {
        imgHinhchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListImageActivity.class);
                startActivityForResult(intent,Request_Code_Image);
            }
        });
    }

    private void event() {
        int indexHinhgoc = random.nextInt(manghinh.length);
        valuehinhgoc = getResources().getIdentifier(manghinh[indexHinhgoc],"drawable",getPackageName());
        imgHinhgoc.setImageResource(valuehinhgoc);
    }

    private void anhxa() {
        imgHinhchon = findViewById(R.id.imageviewHinhchon);
        imgHinhgoc = findViewById(R.id.imageviewHinhgoc);
        manghinh = getResources().getStringArray(R.array.mangtenanimal);
        random = new Random();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && data != null){
            int idhinhchon = data.getIntExtra("hinhchon",-1);
            imgHinhchon.setImageResource(idhinhchon);
            if (idhinhchon == valuehinhgoc){
                Toast.makeText(this, "Dung roi!!", Toast.LENGTH_SHORT).show();
                CountDownTimer  countDownTimer = new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        event();
                    }
                };
                countDownTimer.start();

            }else {
                Toast.makeText(this, "Sai roi!!", Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Ban chua chon con vat", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
