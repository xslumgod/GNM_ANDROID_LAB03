package kz.talipovsn.gnmlab03;

import static kz.talipovsn.gnmlab03.R.drawable.background2;
import static kz.talipovsn.gnmlab03.R.drawable.game;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    // Локальные переменные для доступа к компонентам окна
    private EditText editText;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных доступа к компонентам окна
        editText =   findViewById(R.id.editText);
        checkBox =   findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        spinner =    findViewById(R.id.spinner);
    }

    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onInfo(View v) {
        // Создание второго окна


        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        //Intent intent = new Intent("kz.talipovsn.questionnaire.ResultActivity");

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("nick", editText.getText().toString());
        intent.putExtra("gender", checkBox.isChecked() ? getString(R.string.Мужчина) : getString(R.string.Женщина));
        intent.putExtra("complexity", selectRadioButton.getText());
        intent.putExtra("game", spinner.getSelectedItem().toString());

        intent.putExtra("backgroundgameid", spinner.getSelectedItemId());
        System.out.println(spinner.getSelectedItemId());




        // Запуск второго окна
        startActivity(intent);
    }

}
