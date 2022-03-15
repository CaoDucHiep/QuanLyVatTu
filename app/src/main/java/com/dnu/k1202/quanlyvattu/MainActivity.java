package com.dnu.k1202.quanlyvattu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imgAvatar;
    TextView txtTen, txtMoTa;
    ListView lvDs;
    Button btnThem, btnLamMoi, btnSua;
    List<VatTu> list = new ArrayList<>();
    VatTuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter = new VatTuAdapter(this, R.layout.activity_line_vattu, list);
        imgAvatar = findViewById(R.id.imgAvatar);
        lvDs = findViewById(R.id.lvDs);
        txtTen=findViewById(R.id.txtTen);
        txtMoTa=findViewById(R.id.txtMoTa);
        lvDs.setAdapter(adapter);
        addControl();
        reloadData();

//        list.add(new VatTu(R.drawable.ic_launcher_background, "VueJS", "Lap trinh Web"));
//        list.add(new VatTu(R.drawable.ic_launcher_background, "Java", "Lap trinh java"));
//        list.add(new VatTu(R.drawable.ic_launcher_background, "C", "Lap trinh C"));

        lvDs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int delete=position;
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("CẢNH BÁO");
                builder.setMessage("Bnạ thực sự muôn xóa");
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(delete);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                return false;
            }
        });
        btnThem = (Button) findViewById(R.id.btnThem);
        btnLamMoi = (Button) findViewById(R.id.btnLamMoi);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_them.class);
                startActivity(intent);
            }
        });

    }

    private void reloadData() {
        list.clear();
        adapter.notifyDataSetChanged();
    }

    private void addControl() {
        btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_them.class);
                startActivity(intent);
            }
        });
        lvDs = findViewById(R.id.lvDs);
        list = new ArrayList<>();
        adapter = new VatTuAdapter(this, R.layout.activity_line_vattu, list);
        lvDs.setAdapter(adapter);
    }

    public void init() {
        list.add(new VatTu(R.drawable.ic_launcher_foreground, "VueJS", "Lap trinh Web"));
        list.add(new VatTu(R.drawable.ic_launcher_foreground, "Java", "Lap trinh java"));
        list.add(new VatTu(R.drawable.ic_launcher_foreground, "C", "Lap trinh C"));
    }
    public void lamMoi(){
        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");
        String moTa = intent.getStringExtra("moTa");
        Bundle bundle = getIntent().getExtras();
        int avatar = bundle.getInt("avatar");
        imgAvatar.setImageResource(avatar);
        VatTu vatTu = new VatTu(avatar,ten, moTa);
        list.add(new VatTu(avatar, ten, moTa));
        Toast.makeText(this, ""+vatTu, Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }
}