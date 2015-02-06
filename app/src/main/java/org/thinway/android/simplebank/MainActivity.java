package org.thinway.android.simplebank;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText    mCajaImporte;
    Button      mBotonIngresar;
    Button      mBotonExtraer;
    TextView    mTextoSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCajaImporte = (EditText)findViewById(R.id.cantidadEditText);
        mBotonIngresar = (Button)findViewById(R.id.ingresarButton);
        mBotonExtraer = (Button)findViewById(R.id.extraerButton);
        mTextoSaldo = (TextView)findViewById(R.id.saldoEditText);

        View.OnClickListener ocl = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String cantidad = mCajaImporte.getText().toString();
                mTextoSaldo.setText(cantidad);
            }
        };

        mBotonIngresar.setOnClickListener(ocl);

        View.OnClickListener listenerExtraer = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int saldo = Integer.parseInt(mTextoSaldo.getText().toString());
                int sacado = Integer.parseInt(mCajaImporte.getText().toString());
                int total = saldo - sacado;
                mTextoSaldo.setText("" + total);
            }
        };

        mBotonExtraer.setOnClickListener(listenerExtraer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
