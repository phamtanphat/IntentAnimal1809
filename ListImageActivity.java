package khoapham.ptp.phamtanphat.intentanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import javax.xml.transform.Result;

public class ListImageActivity extends AppCompatActivity {

    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        tableLayout = findViewById(R.id.tableLayout);

        // so cot : 3
        // so dong : 6
        int socot = 3;
        int sodong = 6;
        for (int i = 1 ; i <= sodong ; i++){
            TableRow tableRow = new TableRow(this);
            for (int  y = 1 ; y <= socot ; y++){

                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(350,350);
                imageView.setLayoutParams(layoutParams);
                final int vitri = socot * (i - 1) +  y - 1 ;
                final int idhinh = getResources().getIdentifier(MainActivity.manghinh[vitri],"drawable",getPackageName());
                imageView.setImageResource(idhinh);
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("hinhchon",idhinh);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            tableLayout.addView(tableRow);
        }
    }
}
