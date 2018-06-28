package com.example.android.coffeehouse;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
     int quantity=98;

    float price=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addOne(View v)
    {
        if(quantity<100)
            quantity+=1;
        else
        {
            Toast.makeText(this,"Cannot order more than 100 coffees",Toast.LENGTH_SHORT).show();
           /* Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();*/
        }
        display(quantity);
    }
    public void subOne(View v)
    {
        if(quantity<2)
        {
            Toast.makeText(this,"Cannot order less than one cup",Toast.LENGTH_SHORT).show();
            quantity=1;
        }
        else
            quantity-=1;
        display(quantity);
    }
    private void display(int a)
    {
        TextView quantity =(TextView) findViewById(R.id.quantity);
        quantity.setText(""+a);
    }
    public void order(View v)
    {
        displayOrder(v);
    }
    private void displayOrder(View v) {
        float p = quantity * 5;
        CheckBox cream = (CheckBox) findViewById(R.id.creamBox);
        CheckBox sugar = (CheckBox) findViewById(R.id.sugarBox);
        CheckBox milk = (CheckBox) findViewById(R.id.milkBox);
        if ((cream).isChecked())
            p += 2.0;
        if ((sugar).isChecked())
            p += 0.5;
        if ((milk).isChecked())
            p += 2.0;
        EditText name = (EditText) findViewById(R.id.nameText);
        TextView quantity =(TextView) findViewById(R.id.orderSummary);
        quantity.setText("Name: "+name.getText()+ "\nPrice: $"+ p+"\nThank You");
       // Toast a=Toast.makeText(Context c,"Hello",4 );
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
      //  intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_TEXT,"Name: plapfjaresndfvkj jaejg nvadv 'ladfk q'hgk");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order from JustJava for "+ name.getText());
        intent.putExtra(Intent.EXTRA_TEXT,"Name: "+ name.getText()+"\nPrice: $"+p+"\nThank you");
        intent.putExtra(Intent.EXTRA_EMAIL,"Name: "+ name.getText()+"\nPrice: $"+p+"\nThank you");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void composeEmail(View v)
    {

    }
}

