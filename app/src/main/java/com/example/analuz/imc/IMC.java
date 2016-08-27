//Import necessary package and file
package ;com.example.analuz.imc

import com.example.analuz.imc.R;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//Main activity comienza aqui
public class MainActivity extends Activity {

    //Definición del layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Referencias a los widgets
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logica de validación, y condiciones
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Porfavor escriba su peso");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Porfavor, escriba su altura");
                    e2.requestFocus();
                    return;
                }

//Calculación de valores de los widgets
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculo del IMC
                float bmiValue = calculateBMI(weight, height);

//Interpretar el calculo del IMC
                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    //Calculo del IMC
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpretacion de los calculos finales y condicines
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Muy Obeso";
        } else if (bmiValue < 18.5) {

            return "Bajo de peso";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }



