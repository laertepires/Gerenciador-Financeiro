package es.esy.laerte.gerenciadorfinanceiro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class Tela1 extends AppCompatActivity {


    private ListView lvContas;

    private ArrayAdapter adapter;

    //ArrayList
   // static ArrayList<String> cadastroArray;
    final ArrayList<String> cadastroArray = new ArrayList<String>();

    //posição selecionada
    private int posSelec = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela1.this, Tela2.class);
                startActivityForResult(it,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




        //listview
        lvContas = (ListView) findViewById(R.id.t1_list_view);




        if (requestCode == 2){

            String txt = data.getStringExtra("cadastro").toString();

            //seto array list no novo adapter
            adapter = new ArrayAdapter<>(
                    Tela1.this,
                    android.R.layout.simple_list_item_1,
                    cadastroArray
            );
            String text1 = txt.replace("[", "");
            String text2 = text1.replace("]","");
            cadastroArray.add(text2);

            //inserindo arrayList no listView
            lvContas.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else{
            finish();
        }
        lvContas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                posSelec = i;
                AlertDialog.Builder msg = new AlertDialog.Builder(Tela1.this);
                msg.setTitle("Excluir");
                msg.setMessage("Voce tem certeza que deseja excluir?!?!");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Removendo objeto pessoa!
                        cadastroArray.remove(posSelec);
                        //Notificar o adapter
                        adapter.notifyDataSetChanged();
                        Toast.makeText(
                                getBaseContext(),
                                "Divida removida!",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                msg.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(
                                getBaseContext(),
                                "Cancelado",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                msg.show();
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
