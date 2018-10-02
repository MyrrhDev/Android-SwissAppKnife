package helloworld.com.calclogfrags.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import helloworld.com.calclogfrags.R;

public class Calculadora extends Fragment {
    double result;
    double aux;
    String num2 = "";
    String operation = "";
    TextView textViewResult;
    TextView textViewOp;

    Button buttonComma, buttonCall, buttonErase, buttonClear, button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button11, buttonDiv, buttonPlus, buttonMin, buttonTimes,buttonEqual;


    public Calculadora() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_calculadora, container, false);

        textViewResult = (TextView) v.findViewById(R.id.textViewResult);
        textViewOp = (TextView) v.findViewById(R.id.textViewOp);

        button0 = (Button) v.findViewById(R.id.button0);
        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);
        button3 = (Button) v.findViewById(R.id.button3);
        button4 = (Button) v.findViewById(R.id.button4);
        button5 = (Button) v.findViewById(R.id.button5);
        button6 = (Button) v.findViewById(R.id.button6);
        button7 = (Button) v.findViewById(R.id.button7);
        button8 = (Button) v.findViewById(R.id.button8);
        button9 = (Button) v.findViewById(R.id.button9);
        button11 = (Button) v.findViewById(R.id.button11);

        buttonEqual = (Button) v.findViewById(R.id.buttonEqual);
        buttonDiv = (Button) v.findViewById(R.id.buttonDiv);
        buttonMin = (Button) v.findViewById(R.id.buttonMin);
        buttonPlus = (Button) v.findViewById(R.id.buttonPlus);
        buttonTimes = (Button) v.findViewById(R.id.buttonTimes);
        buttonComma = (Button) v.findViewById(R.id.buttonComma);
        buttonClear = (Button) v.findViewById(R.id.buttonClear);
        buttonErase = (Button) v.findViewById(R.id.buttonErase);

        //buttonCall = (Button) v.findViewById(R.id.buttonCall);

        //restoreResult();

        View.OnClickListener call = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + textViewResult.getText().toString()));
                startActivity(intent);
            }
        };

        View.OnClickListener appendNumber = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;

                textViewOp.append(b.getText());
                num2 += b.getText().toString();

                double d = performOperation();

                textViewResult.setText(String.valueOf(d));
            }
        };

        View.OnClickListener appendOperation = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aux = Double.parseDouble(textViewResult.getText().toString());

                result = Double.parseDouble(textViewResult.getText().toString());

                Button b = (Button) view;

                operation = b.getText().toString();

                textViewOp.append(operation);

                textViewResult.setText("");

                num2 = "";
            }
        };

        View.OnClickListener equal = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = performOperation();
                textViewResult.setText(String.valueOf(result));
                //saveResult();
            }
        };

        View.OnClickListener clearEverything = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = " ";
                textViewResult.setText(" ");
                textViewOp.setText(" ");
                operation = "";
            }
        };

        View.OnClickListener clearThis = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = " ";
            }
        };

        button0.setOnClickListener(appendNumber);
        button1.setOnClickListener(appendNumber);
        button2.setOnClickListener(appendNumber);
        button3.setOnClickListener(appendNumber);
        button4.setOnClickListener(appendNumber);
        button5.setOnClickListener(appendNumber);
        button6.setOnClickListener(appendNumber);
        button7.setOnClickListener(appendNumber);
        button8.setOnClickListener(appendNumber);
        button9.setOnClickListener(appendNumber);
        button11.setOnClickListener(appendNumber);
        buttonComma.setOnClickListener(appendNumber);

        buttonCall.setOnClickListener(call);

        buttonDiv.setOnClickListener(appendOperation);
        buttonMin.setOnClickListener(appendOperation);
        buttonPlus.setOnClickListener(appendOperation);
        buttonTimes.setOnClickListener(appendOperation);

        buttonEqual.setOnClickListener(equal);
        buttonClear.setOnClickListener(clearEverything);
        buttonErase.setOnClickListener(clearThis);

        return v;
    }

    //void restoreResult(){
        //SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);

        //this.textViewResult.setText(sp.getString("resultado", ""));
    //}

    //void saveResult(){
        //SharedPreferences sp = getSharedPreferences("prefs", 0);

        //SharedPreferences.Editor editor = sp.edit();

        //editor.putString("resultado",textViewResult.getText().toString());

        //editor.commit();
    //}

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putString("result", textViewResult.getText().toString());
    }

    /*
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewResult.setText(savedInstanceState.getString("result"));

    }*/

    double performOperation(){
        double d = Double.parseDouble(this.num2);
        if (operation.equals("+")){
            d += result;
        }
        else if (operation.equals("-")){
            d = result - d;
        }
        else if (Objects.equals("/", operation)){
            d = result / d;
        }
        else if (Objects.equals(operation, "*")){
            d *= result;
        }
        return d;
    }

    /*
    void call (String number) {
      for(int i = 0; i < text.length(); ++i) {
     if(!isNum(text.charAt(i))) {
           textViewResult.setText("error");
          return;
     }
     String num = "tel:" + text;
     Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(num);
     startActivity(intent);
     }*/

}
