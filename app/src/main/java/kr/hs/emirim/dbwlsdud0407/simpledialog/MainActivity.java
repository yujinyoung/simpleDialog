package kr.hs.emirim.dbwlsdud0407.simpledialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button but;
    boolean checkArr[]={false,true,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but=(Button)findViewById(R.id.but_dialog);
        but.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    String[] items={"젤리빈", "킷켓","롤리팝"};
    @Override
    public void onClick(View v) {

        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("First Dialog");
        /*dialog.setSingleChoiceItems(items,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                but.setText(items[which]);

            }
        });*/
        dialog.setMultiChoiceItems(items, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                but.setText(items[which]);

            }
        });
        dialog.setIcon(R.drawable.images);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(MainActivity.this, "대화상자의 확인 버튼을 클릭하셨습니다.",Toast.LENGTH_LONG ).show();
            }
        });
        dialog.show();
    }
}
